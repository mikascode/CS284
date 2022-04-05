
//Name: Rashmika Batra 
//Section: RI 
//I pledge my honor that I have abided by the Stevens Honor System

public class Complexity {
	
	
	
	public static void method1 (int n) { 
		//Implement a method of time complexity of O(n^2) 
		int counter=1; 
		for (int i = 0; i<n; i++) { 
			for (int j=0; j<n; j++) { 
			
			System.out.println("Operation: " + counter); 
			counter++; 
			}
			}		 
			}
	
	public static void method2 (int n) { 
		//Implement a method of time complexity of O(n^3) 
		int counter=1; 
		for (int i = 0; i<n; i++) { 
			for (int j=0; j<n; j++) { 
				for (int k=0; k<n; k++) { 
			
			System.out.println("Operation: " + counter); 
			counter++; 
			
			}
			}		 
			}
			} 
	
	public static void method3 (int n) { 
		//Implement a method of time complexity of O (log n) 
		int counter=0; 
		for (int i=1; i<=n; i*=2){ 
			System.out.println("Operation: " + counter); 
			counter++; 
			
			}
			}
	
	public static void method4 (int n) { 
		//Implement a method of time complexity of O(n log n) 
		int counter=1; 
		for (int i=0; i<=n; i++){ 
			for (int k=1; k<=n; k*=2){ 
				System.out.println("Operation: " + counter); 
				counter++; 
			
			}
			}
		} 
	
	public static void method5 (int n) { 
		//Implement a method of time complexity of O(log log n) 
		int counter=1; 
		
		for (int i=2; i<=n; i*=i){ 
			System.out.println("Operation: " + counter); 
			counter++; 
			
			}
		
			}
	
	
	
	public static int method6 (int n) { 
		//Implement a method of time complexity of O(2^n) 
		int counter= 0; 
	
		
		
		System.out.println("Operation: " + counter); 
		counter+=1; 
		
		
		if (n<=0) {
			return 0; 
			} 		
		
		return  method6(n-2)+ method6(n-1);
		
		
	}
	
	
	
	public static void main(String[] args) { 
		 
	method6(2); 
	
	
}
}
		
	


