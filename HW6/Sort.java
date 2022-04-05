//Rashmika Batra 
//I pledge my honor that I have abided by the Stevens Honor System. 
//Recitation section RI 
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

public class Sort {
	
	private static class Interval { 
		//data fields 
		/**The reference to the upper bound */		
		private int lower; 
		/**The reference to the lower bound */
		private int upper; 
	
		//Constructors 
		/** Creates an interval with an upper and lower bound  
		* @param lower, the lower bound 
		* @param upper, the upper bound
						*/
	public Interval (int lower, int upper) {  
		this.lower=lower; 
		this.upper=upper;
	
	}
		
	// Methods
	/** Get the lower bound of the interval. 
	* @return an integer representing the lower bound of the interval. 
	*/
	public int getLower() { 
		return this.lower; 
		
	}
	
	/** Get the lower bound of the interval. 
	* @return an integer representing the lower bound of the interval. 
	*/
	public int getUpper() { 
		return this.upper; 
	}
	
	/** See if an interval is equal to another object.  
	 * @param Object o, the object you want to compare. 
	* @return a boolean representing if the two objects are equal. 
	*/
	public boolean equals (Object o) { 
		if (this==o) { 
			return true; 
		}
		if (!(o instanceof Interval)) { 
			return false; 
		}
		Interval a = (Interval)o; 
		return this.getLower()==a.getLower() && this.getUpper()==a.getUpper(); 
	}
	
	/** Get the hash code of an Interval. 
	* @return an integer representing the hash code of the interval. 
	*/
	public int hashCode() { 
		return this.lower * this.lower * this.upper; 
		
	
	}
	} 

	
	/** Swaps two values in an array. 
	* @param array,the array you want to swap values of. 
	* @param int a, the index of the element you want swapped. 
	* @param int b, the index of the second element you want to swap.   
	*/
	private static  <T extends Comparable<T>> void swap(T[] array, int a, int b) {
		T temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	/** Partitions an array. 
	* @param array,the array you want to partition. 
	* @param int first, the bound of the partition.  
	* @param int b, the bound of the partition.    
	* @return the index of the pivot value 
	*/
	private static  <T extends Comparable<T>>  int  partition (T[] array, int first, int last) { 
		
		
		int middle = first+last/2; 
		if (array[first].compareTo(array[middle])>0) { //if the first element is greater than the second, sort the array 
			bubbleSort(array);  
		}
		if (array[middle].compareTo(array[last])>0 ) { //sorting if array is out of order 
			
			bubbleSort(array); 
		}
		if (array[first].compareTo(array[last])>0 ) { //sorting if array is out of order 
			bubbleSort(array); 
		}
//		if(array.length==3) { 
//			return -1; 
//		}
		swap(array, first, middle); //swap the median of the three elements (now at position middle) with the element at position first.
		
		T pivot = array[first]; //Use the element at position first (now the median of the three elements) as  pivot element.
		int up = first; 
		int down= last; 
		
		do { 
			while (up<last && (pivot.compareTo(array[up])>=0)) { 
				up++; 
			}
			while (pivot.compareTo(array[down])<0) { 
				down--; 
				
			}
			
			if (up<down) { //if up is to the left of down 
				swap(array, up, down); 
			}
		} while (up<down ); //Repeat while up us left of down 
		
		//Exchange array of first and array of down and put the pivot value where it belongs
		swap(array,first,down); 
		return down; 
	}

	/** Performs Bubble Sort on an array, 
	* @param array,the array you want sort.
	* @return  the sorted array.   
	*/
	
	public static <T extends Comparable<T>> T[] bubbleSort(T[] array) {
		boolean swapped = true;
		while (swapped) {
			swapped = false;
			for (int i = 0; i < array.length; ++i) {
				if (i < array.length - 1) {
					if((array[i].compareTo(array[i + 1])>0)) { 
						swap(array, i, i + 1);
						swapped = true;
					}
				}
			}
		}
		return array;
	}
	
	/** Performs Iterative Quicksort on an array, 
	* @param array,the array you want sort.
 
	*/	
	
	public static <T extends Comparable<T>> void sort(T[] array) { 
		HashSet<Interval> set = new HashSet<Interval>();
		Stack<Interval> stack = new Stack <Interval> (); 
		int last= array.length-1; 
		int first= 0; 
		Interval indicies = new Interval(first,last); 
		set.add(indicies); 
		Iterator <Interval> iterator =  set.iterator(); 
		while (iterator.hasNext()){ //while there are still elements in the set 
			Interval current = iterator.next(); //iterating through the set 
			set.remove(current); //remove current element 
			if(current.lower<=current.upper && current.lower>=0 && current.upper<=array.length-1) {
				int pivot= partition(array,current.lower, current.upper); //set pivot equal to the partition of the array at the lower and upper indexes 
				set.add(new Interval(current.lower,pivot));  //add to the set 
				set.add(new Interval(pivot+1,current.upper)); 
				set.add(new Interval(pivot+1,current.lower));
				set.add(new Interval(current.upper,pivot)); 
		}
		}
		}
	
		

	
	public static <T> String toString(T[] array) { 
		StringBuilder s = new StringBuilder(); 
		for(int i = 0; i<array.length; i++) { 
			s.append(array[i].toString()+ " "); 
		}
		return s.toString(); 
	}
	public static void main(String args[]) { 
	
		Interval b = new Interval(6,5); 
		Interval c = new Interval(6,5); 
		Interval d = new Interval(20,5); 
		
		int h = 5;  
	
		System.out.println(b.getLower());
		System.out.println(b.getUpper());
		System.out.println(b.equals(c));
		System.out.println(b.equals(d));
		System.out.println(b.equals(h));
		
		
		Integer[] array2 = {700, 800, 900, 10000, 749, 7394004, 28393030, 38439438}; 
		sort(array2); 
		System.out.println(toString(array2)); 
		//System.out.println(partition(array, 0, 6)); 
		//System.out.println(toString(array)); 
		
	}
	
	
}
