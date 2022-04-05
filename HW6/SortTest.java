import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class SortTest {

	@Test
	void testsortIntegers() {
		Integer[] array = {3,8,1,9,8,4,5}; 
		Sort.sort(array); 
		assertEquals(Sort.toString(array), "1 3 4 5 8 8 9 "); 
		Integer[] array2 = {100, 1024, 678, 5}; 
		Sort.sort(array2); 
		assertEquals(Sort.toString(array2), "5 100 678 1024 "); 
	}
	
	void testsortStrings() {
		String[] array =  {"dog", "cat","zebra", "butterfly"}; 
		Sort.sort(array); 
		assertEquals(Sort.toString(array), "butterfly cat dog zebra "); 
		String[] array2 =  {"Math", "Science",  "English"}; 
		Sort.sort(array2); 
		assertEquals(Sort.toString(array2), "English Math Science "); 
	}
	
}
