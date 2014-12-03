import java.util.Iterator;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class OurPriorityQueueOnAHeap<E extends Comparable<E>> implements OurQueue<E> {

	private ArrayList<E> dataTree = new ArrayList<E>();


	@Override
	public int size() {
		return dataTree.size();
	}

	@Override
	public boolean isEmpty() {
		return dataTree.size() == 0;
	}

	@Override
	public E head(){
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return dataTree.get(0);		
	}

	@Override
	public void enqueue(E element) {
		dataTree.add(this.dataTree.size(), element);
		int newIndex = dataTree.size() - 1;
		while(newIndex > 0 && dataTree.get(newIndex).compareTo(dataTree.get(parentIndex(newIndex))) < 0){
			swap(newIndex, parentIndex(newIndex));

			newIndex = parentIndex(newIndex);
		}
	}


	@Override

	public E dequeue() {
		if(dataTree.size() == 0){
			throw new NoSuchElementException();
		}
		E temp = dataTree.get(0);
		dataTree.set(0, dataTree.get(dataTree.size() - 1));
		dataTree.set(dataTree.size() - 1, temp);
		return null;
		//while(leftChildIndex(newIndex).compareTo(dataTree.get(newIndex)) < 0) {
		//	if(rightChildIndex(dataTree.size() - 1) < dataTree.size()){
			//	swap((rightChildIndex(dataTree.size() - 1));
			}
		
		/*To finish out this method I need to create if statements to check weather or not 
		 * there is a left of right child and then swap with the parent until both are 
		 * bigger then the parent

	    */

	@Override
	public void clear() {
		dataTree.clear();
	}


	/* Helper methods that will make the public methods MUCH easier to write 
	 * These are not required, but it is highly recommended that you figure them
	 * out and use them. */

	// swaps the values in two nodes of the heap, given their indices in the ArrayList
	private void swap(int index1, int index2) {
		E temp = dataTree.get(index1);
		dataTree.set(index1, dataTree.get(index2));
		dataTree.set(index2, temp);
	}

	// determines the index of a node's parent from the child node's index
	private int parentIndex(int childIndex) {

		return (childIndex - 1) / 2;
	}

	// determines the index of a node's left child from the parent node's index
	private int leftChildIndex(int parentIndex) {

		return 2 * parentIndex + 1;
	}

	// determines the index of a node's right child from the parent node's index
	private int rightChildIndex(int parentIndex) {

		return 2 * parentIndex + 2;
	}
}