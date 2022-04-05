import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Treap.Node;

class TestTreap {
	@Test
	void addTest() {
		Treap<Integer> testTree = new Treap <Integer >();
		testTree.add(4,19); 
		testTree.add(2,31);
		assertTrue(testTree.find(4)); 
		assertTrue(testTree.find(2));
		assertFalse(testTree.add(2));  
	}
	
	@Test
	void deleteTest() { 
		Treap<Integer> testTree = new Treap <Integer >();
		testTree.add(6,70); 
		testTree.add(1,84);
		testTree.add(3,12); 
		testTree.add(5,83);
		testTree.add(7,26);
		assertFalse(testTree.delete(2)); 
		testTree.delete(3); 
		assertFalse(testTree.find(3)); 
		
	}
	
	@Test
	void findTest() { 
		Treap<Integer> testTree = new Treap <Integer >();
		testTree.add(6,70); 
		testTree.add(1,84);
		testTree.add(3,12); 
		testTree.add(5,83);
		testTree.add(7,26);
		assertFalse(testTree.find(2)); 
		assertTrue(testTree.find(6)); 
		assertTrue(testTree.find(1)); 
		assertTrue(testTree.find(3)); 
		assertTrue(testTree.find(5)); 
		assertTrue(testTree.find(7)); 
		
	}
	

}