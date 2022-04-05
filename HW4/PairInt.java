package Maze;
//Name: Rashmika Batra 
//Section: RI 
//I pledge my honor that I have abided by the Stevens Honor System. 

public class PairInt {
	
	private int x; 
	private int y; 
	
	public PairInt(int x, int y) { 
		this.x= x; 
		this.y=y; 
	}
	//getter methods
	public int getX() { 
		return x; 
		
	}
	public int getY() { 
		return y; 
		
	}
	//setter methods 
	public void setX(int x) { 
		this.x=x; 
		
	}
	public void setY(int y) { 
		this.y=y; 
		
	}
	
	public boolean equals(Object p) { 
		if (p==this) { 
			return true; 
		}
		//if p is not a PairInt, it cannot be equal  
		if (!(p instanceof PairInt)) {
			return false; 
		}
		//if it is a PairInt, we can use the getter methods to compare the two  
		if (p instanceof PairInt) { 
			int a; 
			int b; 
			int c; 
			int d; 
			a=((PairInt) p).getX(); 
			b= ((PairInt) p).getY(); 
			c=this.getX(); 
			d=this.getY(); 
			if (a==c && b==d) { 
				return true; 
			}
			//if none of the conditions are met, return false
		}
		return false; 
	} 
	
	//building a string to show the coordinates 
	public String toString() { 
		StringBuilder string = new StringBuilder();  
		string.append("("); 
		string.append(x);
		string.append(",");
		string.append(y);
		string.append(")");
		return string.toString(); 
		
		
	}
	//creating a copy 
	public PairInt copy() { 
		return new PairInt(this.x,this.y); 
	}
	//testing  
	 public static void main(String[] args) {
		 PairInt test = new PairInt(2,3); 
		 PairInt test2 = new PairInt(4,0); 
		 int a= 5; 
		
		 System.out.println(test.equals(a));
	    	
	    }
}
