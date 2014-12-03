import static org.junit.Assert.*;
import java.util.NoSuchElementException;
import org.junit.Test;

public class TestPriorityQueue {
	@Test
	public void TestEmptyQueue() {
		OurQueue<String> queue = new OurPriorityQueueOnAHeap<String>();
		assertTrue(queue.isEmpty());
		assertEquals(0,queue.size());
	}
	
	@Test
	public void TestNonEmptyQueue() {
		OurQueue<String> queue = new OurPriorityQueueOnAHeap<String>();
		queue.enqueue("kiwi");
		assertFalse(queue.isEmpty());
		assertEquals(1, queue.size());
	}	
	
	@Test(expected=NoSuchElementException.class)
	public void TestElementEmptyQueue(){
		OurQueue<String> queue = new OurPriorityQueueOnAHeap<String>();
		queue.head();
	}
	
	@Test(expected=NoSuchElementException.class)
	public void TestRemoveFromEmptyQueue(){
		OurQueue<String> queue = new OurPriorityQueueOnAHeap<String>();
		queue.dequeue();
	}
	
	@Test
	public void TestLargerQueue() {
		OurQueue<String> queue = new OurPriorityQueueOnAHeap<String>();
		queue.enqueue("banana");
		queue.enqueue("date");
		queue.enqueue("clementine");
		queue.enqueue("apple");
		
		assertEquals("apple", queue.dequeue());
		assertEquals("banana", queue.dequeue());
		assertEquals("clementine", queue.dequeue());
		assertEquals("date", queue.dequeue());
		
	}
	
	@Test
	public void TestClear() {
		OurQueue<String> queue = new OurPriorityQueueOnAHeap<String>();
		queue.enqueue("banana");
		queue.enqueue("date");
		queue.enqueue("clementine");
		queue.enqueue("apple");
		
		queue.clear();
		assertEquals(0, queue.size());	
	}
}