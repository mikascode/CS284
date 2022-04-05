//Rashmika Batra 
//I pledge my honor that I have abided by the Stevens Honor System. 
//Recitation section RI 
import java.util.Random;
import java.util.Stack;

public class Treap <E extends Comparable <E>>{
	
	private static class Node<E> { 
		//data fields 
		/**The reference to the data */
		public E data; 
		/**Reference to the priority */
		public int priority; 
		/**Reference to the left child */
		public Node<E> left; 
		/**Reference to the right child */
		public Node<E> right; 
		
		
		//Constructors 
		/** Creates a new node with a null next field. 
		* @param data The data stored
		*  @param priority the priority of the node
				*/

		public Node(E data, int priority) { 
			this.data=data; 
			this.priority= priority; 
			this.left=null; 
			this.right=null; 
		}
		
		// Methods
				/** Return the root of the treap when rotated right.
				* @return the root of the treap when rotated right.
				*/
			
			Node<E> rotateRight() {
				Node<E> a =this.left; 
				Node<E> r = a.right; 
				a.right=this; 
				this.left= r; 
				return a; 
			} 
			/** Return the root of the treap when rotated left.
			* @return the root of the treap when rotated left.
			*/
			Node<E> rotateLeft() {
				Node <E> a= this.right; 
				Node <E> r= a.left; 
				a.left=this; 
				this.right=r; 
				return a; 
			}
			/** Return a string representation of the node.
			* @return A string representation of the data fields
			*/
			public String toString() {
				return data.toString();
			}
	}
	
	//data fields 
	/**Generates a random priority */
	private Random priorityGenerator; 
	/**The reference to the root */
	private Node<E> root; 
	
	

	//Constructors 
	/** Creates an empty treap and initializes priorityGenerator using new Random().
			*/
	public Treap() {
		this.priorityGenerator= new Random(); 
		this.root=null; 
}
	/** Creates an empty treap and initializes priorityGenerator using new Random()seed.
	*/
	public Treap(long seed) { 
		this.priorityGenerator= new Random(seed); 
		this.root=null; 
	}
	
	// Methods
	/** Inserts a given element into the treap. 
	 * @param  key the key value of the node you want to add. 
	* @return a boolean representing if the node has been successfully added or not.
	Node will not be added if another node with the same key value already exists. 
	*/
	boolean add(E key) { 
		Node<E> newnode = new Node<E>(key,priorityGenerator.nextInt()); 
		return add(key,newnode.priority); 
	}
	/** Inserts a given element into the treap. 
	 * @param  key the key value of the node you want to add. 
	 *  @param priority, the integer value of the priority of the node. 
	* @return a boolean representing if the node has been successfully added or not.
	Node will not be added if another node with the same key value already exists. 
	*/
	boolean add (E key, int priority) { 
		Node<E> newnode = new Node<E>(key,priority); 
		if (this.root == null) { 
			root=newnode; 
			return true; 
		}
		Node<E> current= root; 
		Stack<Node<E>> stack = new Stack<Node<E>>(); 
		while (current!=null) { 
			stack.push(current); 
			if (key.compareTo(current.data)>0) { 
				if (current.right==null) { 
					current.right=newnode; 
					break; 
				}
				current=current.right; 
			}
			else if((key.compareTo(current.data)<0)) { 
				if (current.left==null) { 
					current.left=newnode; 
					break; 
				}
				current=current.left; 
			}
			else { 
				return false; 
			}
		}
		reheap(stack,newnode); 
		return true; 
	}
	
	/** Helper function for add that rearranges the tree based on priority. 
	 * @param  stack the stack from the add function that had all the nodes. 
	 *  @param current, the node that is to be added, from the add function. 
	*/
	void reheap (Stack<Node<E>> stack, Node<E> current) { 
		if (stack.isEmpty()) { 
			return; 
		}
	
		while (!stack.isEmpty() && current.priority>stack.peek().priority) { 
			Node<E> parent= stack.peek(); 	
			stack.pop(); 
			if (root==parent) { 
				if (current==parent.right) { 
					root = parent.rotateLeft(); 
					break; 
				}
				else { 
					root= parent.rotateRight(); 
					break; 
				}
			}
				if (parent.right==current)  { 
					parent.rotateLeft(); 
					if(stack.peek().left==parent) { 
						stack.peek().left= current ; 
					}
					else { 
						stack.peek().right=current; 
					}
				} 
				  if (parent.left==current) { 
					  parent.rotateRight(); 
					  if(stack.peek().left==parent) { 
						  stack.peek().left= current; 
				}
					  else { 
						  stack.peek().right=current; 
					  }
			}
		}		
	}
	
	/** Deletes a node from the treap. 
	 * @param  key the key value of the node you want to remove. 
	* @return a boolean representing if the node has been successfully deleted or not.
	Node will not be deleted no node in the treap with that key value exists. 
	*/

	boolean  delete (E key) { 
		if (find(key)==false ) { 
			return false; 
		}
		 helper(key,root); 
		 return true; 
	}
	
	/** helper function for deletion that keeps track of the root to update it accordingly. 
	 * @param  root, the root.
	 * @param  key, the key of the root that you want to delete. 
	* @return the root.
	*/
	
	public  Node<E> helper(E key, Node<E> root) { 
        if (root == null) {
            return null;
        }
        
        E data = root.data; 
        int compResult = key.compareTo(data);
        
        if (compResult < 0) {
            root.left = helper(key, root.left);
        }
        else if (compResult > 0) {
            root.right = helper(key, root.right);
        }
        else {
        	 if (root.left!= null && root.right!= null) { 
        		 int leftpriority=root.left.priority; 
        		 int rightpriority=root.right.priority; 
        		 
	            	if (rightpriority>leftpriority) { 
                 root = root.rotateLeft(); 
                 root.left = helper(key, root.left);
             }
            if (root.right == null && root.left == null) { 
                root = null;
                
            }
                else {
                    root = root.rotateRight();
                    root.right = helper(key, root.right);
                }
            }
        	 
            else {
            	if (root.left!=null) { 
                Node<E> e = root.left; 
                root=e; 
            	}
                else { 
                	  Node<E>e= root.right;
                	  root=e; 
                }
            }
            }
        return root;
	}
	/** Finds a node with the given key in the treap rooted at root. 
	 * @param root, the root of the treap. 
	 * @param  key the key value of the node you want to find. 
	* @return a boolean representing if the node has been found or not. 
	*/

	boolean find(Node<E> root, E key) {
			if (root == null) {
				return false;
			}
			int compResult = key.compareTo(root.data);
			if (compResult == 0)
				return true;
			else if (compResult < 0)
				return find(root.left, key);
			else
				return find(root.right, key);
		}
	/** Finds a node with the given key. 
	 * @param  key the key value of the node you want to find. 
	* @return a boolean representing if the node has been found or not. 
	*/
	public boolean find(E key) { 
		return find(root, key);
	}
	
	/** Converts a the treap to a string.
	* @param current The local root
	* @param depth The depth
	*/
	private String toString(Node<E> current, int depth) {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<depth;i++) {
			sb.append(" ");
		}
		if (current==null) {
			sb.append("null\n");
		} else {
			sb.append( "(" + "key=" + current.data.toString()+ "," + " priority=" + current.priority+ ")"+ "\n");
			sb.append(toString(current.left, depth+1));
			sb.append(toString(current.right,depth+1));
		}
		return sb.toString();
	}
	
	public String toString() {
		return toString(root,0);
	}
	
	public static void main(String[] args) {
		Treap<Integer> testTree = new Treap <Integer >();
		testTree.add(4,19); 
		testTree.add(2,31);
		Node<Integer> newnode = new Node<Integer>(5,4); 
		Node<Integer> left = new Node<Integer>(7,9); 
		Node<Integer> right = new Node<Integer>(7,9); 
		
		newnode.left=left; 
		newnode.right=right; 
		
		
		System.out.println("left" + newnode.rotateLeft().toString()); 
		
		
		testTree.add(6,70); 
		testTree.add(1,84);
		testTree.add(3,12); 
		testTree.add(5,83);
		testTree.add(7,26);
		System.out.print(testTree);
		testTree.delete(7);
		System.out.print("DELETED" + testTree);
	//testTree.delete(7);
	//System.out.print(testTree);
		
	}

}
	


