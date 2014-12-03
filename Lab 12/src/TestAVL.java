import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestAVL {
	private AVLTree<Integer,String> emptyTree;
	private AVLTree<Integer,String> eightNodesTree;
	private AVLTree<Integer,String> sixNodesTree;
	
	@Before
	public void setUp() {
		emptyTree = new AVLTree<Integer,String>();
		eightNodesTree = new AVLTree<Integer,String>();
		eightNodesTree.add(4, "apple");
		eightNodesTree.add(6, "banana");
		eightNodesTree.add(1, "strawberry");
		eightNodesTree.add(3, "kiwi");
		eightNodesTree.add(7, "lemon");
		eightNodesTree.add(10, "lime");
		eightNodesTree.add(5, "mango");
		eightNodesTree.add(8, "pear");
		

	}
	

	@Test
	public void TestEmpty() {
		assertTrue(emptyTree.isEmpty());
	}
	
	@Test
	public void TestNonEmpty() {
		emptyTree.add(4, "apple");
		assertFalse(emptyTree.isEmpty());
	}
	
	@Test (expected=DuplicateKeyException.class)
	public void TestDuplicateKey() {
		eightNodesTree.add(7, "guava");
	}

	@Test
	public void TestAddGetRoot() {
		emptyTree.add(4, "apple");
		assertEquals("apple", emptyTree.get(4));
	}
	
	@Test
	public void TestGetFromEmpty() {
		assertNull(emptyTree.get(4));
	}	
	
	@Test
	public void TestGet() {
		assertEquals("strawberry", eightNodesTree.get(1));
		assertEquals("lemon", eightNodesTree.get(7));
	}	
	
	@Test
	public void TestGetNotThere() {
		assertNull(eightNodesTree.get(2));
	}	
	
	@Test (expected=NullPointerException.class)
	public void TestNullKey() {
		assertNull(eightNodesTree.get(null));
	}
	
	
	@Test
	public void TestClear() {
		eightNodesTree.clear();
		assertTrue(eightNodesTree.isEmpty());
		assertNull(eightNodesTree.get(4));
	}	
	
	@Test
	public void TestAddThenCheck() {	
		assertEquals("strawberry", eightNodesTree.get(1));
		assertEquals("pear", eightNodesTree.get(8));
		assertEquals("mango", eightNodesTree.get(5));
		assertEquals("lime", eightNodesTree.get(10));
		assertEquals("kiwi", eightNodesTree.get(3));
		assertEquals("banana", eightNodesTree.get(6));
		assertEquals("apple", eightNodesTree.get(4));
		assertEquals("lemon", eightNodesTree.get(7));
	}	
	
	@Test
	public void TestIfBalancedEightNodes() {
		assertTrue(eightNodesTree.inOrder());
	}
	
	@Test
	public void TestIfRightRight() {
		
		sixNodesTree = new AVLTree<Integer,String>();
		sixNodesTree.add(4, "apple");
		sixNodesTree.add(6, "banana");
		sixNodesTree.add(1, "strawberry");
		sixNodesTree.add(3, "kiwi");
		sixNodesTree.add(7, "lemon");
		sixNodesTree.add(10, "lime");
		
		assertTrue(sixNodesTree.inOrder());
	}
	
	@Test
	public void TestIfLotsAndLots() {
		
		sixNodesTree = new AVLTree<Integer,String>();
		sixNodesTree.add(4, "apple");
		sixNodesTree.add(6, "banana");
		sixNodesTree.add(13, "breads");
		sixNodesTree.add(1, "strawberry");
		sixNodesTree.add(3, "kiwi");
		sixNodesTree.add(12, "yeast");
		sixNodesTree.add(7, "lemon");
		sixNodesTree.add(10, "lime");
		sixNodesTree.add(5, "mango");
		sixNodesTree.add(14, "yellow");
		sixNodesTree.add(15, "pikachu");
		sixNodesTree.add(16, "The Sky");
		sixNodesTree.add(8, "pear");
		sixNodesTree.add(2, "grapes");
		sixNodesTree.add(9, "brooms");
		sixNodesTree.add(11, "candles");


		assertTrue(sixNodesTree.inOrder());
	}
	
	
	// to-do: tests for remove
}