import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class CountingSortTest {

	@Test
	void testsortIntegers() {
		int[] array = {3,8,1,9,8,4,5}; 
		CountingSort.sort(array); 
		assertEquals(Arrays.toString(array), "[1, 3, 4, 5, 8, 8, 9]"); 
		int[] array2 = {100, 1024, 678, 38928, 20920}; 
		CountingSort.sort(array2); 
		assertEquals(Arrays.toString(array2), "[100, 678, 1024, 20920, 38928]"); 
	}
	}


