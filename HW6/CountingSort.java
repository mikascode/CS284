import java.util.Arrays;

public class CountingSort {
	/** Executes counting sort on an array 
	* @param A, the integer array to be sorted 
					*/
	public static void sort(int[] A) { 
		int size= A.length - 1; 
        int[] B = new int[A.length];
        int k = A[0];
        for (int i = 1; i < size; i++) {
          if (A[i] > k)
            k = A[i];
        }
        int n = A.length;
        int C[] = new int[k+1];
        for (int i = 0; i < k+1; i++)
            C[i] = 0;
        for (int j = 0; j < n; j++)
            C[A[j]]= C[A[j]]+1;
 
        for (int i = 1; i <= k; i++)
            C[i] = C[i]+ C[i - 1];
 
        for (int j = n - 1; j >= 0; j--) {
            B[C[A[j]] - 1] = A[j];
            C[A[j]] = C[A[j]] - 1; 
        }
        for (int i = 0; i < n; i++)
            A[i] = B[i];
    }
	
	
	
	public static void main(String args[]) { 
		
//		Interval b = new Interval(6,5); 
//		Interval c = new Interval(6,5); 
//		int h = 5;  
//		
//		System.out.println(b.getLower());
//		System.out.println(b.getUpper());
//		System.out.println(b.equals(c));
		
		int[] array = {100, 1024, 678, 38928, 20920}; 
		sort(array); 
		
		System.out.println(Arrays.toString(array)); 
		//System.out.println(toString(array)); 
		
	}
	

}
