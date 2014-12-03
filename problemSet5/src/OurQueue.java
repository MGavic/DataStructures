public interface OurQueue<E> {
	/*
	 * Returns the number of elements in this queue.
	 */
	public int size();
	
	
	/*
	 * Returns true if this collection contains no elements, false 
	 * otherwise.
	 */
	public boolean isEmpty();
	
	
	/*
	 * Retrieves, but does not remove, the head of this queue. 
	 * Throws a NoSuchElementException if this queue is empty. 
	 */
	public E head();
	
	
	/*
	 * Adds an element to the end of the queue
	 */
	public void enqueue(E element);
	
	
	/*
	 * Retrieves and removes the head of this queue. 
	 * Throws a NoSuchElementException if this queue is empty. 
	 */
	public E dequeue();
	
	
	/*
	 * Removes all of the elements from this queue, making it empty.
	 */
	public void clear();
	
}