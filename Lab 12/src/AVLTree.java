import java.util.ArrayList;

public class AVLTree <K extends Comparable<K>, V> {
	private AVLNode root = null;

	/*
	 * true if the tree is empty, false otherwise
	 */
	public boolean isEmpty() {
		return root == null;
	}


	/*
	 * Adds a given value indexed with a given key to the tree according to the
	 * binary search structure.  If the key is already present, this method throws
	 * a DuplicateKeyException.
	 */
	public void add(K key, V value) throws DuplicateKeyException{
		if(root == null){
			root = new AVLNode(key, value);
			return;
		}
		
		AVLNode current = root;
		boolean whileWorking = true;
		
		while(whileWorking){
			if(key.compareTo(current.key) < 0){
				if(current.leftChild == null){
					current.leftChild = new AVLNode(key, value);
					current.leftChild.parent = current;
					whileWorking = false;
				} else{
					current = current.leftChild;
				}
			}else if(key.compareTo(current.key) > 0){
				if(current.rightChild == null){
					current.rightChild = new AVLNode(key,value);
					current.rightChild.parent = current;
					whileWorking = false;
				}else{
					current = current.rightChild;
				}
			}else{
				throw new DuplicateKeyException(key);
			}
		}
		
		while(current.parent != null){
			current.resetHeight();
			//Check the height differences and balance if need be
			//Need to make sure in our rotations to change internal heights
			if(current.balanceFactor() == -2){
				if(current.rightChild.balanceFactor() == -1){
					rightRight(current);
					current = current.parent;
				}else{
					rightLeft(current);
					current = current.parent;
				}
			}else if(current.balanceFactor() == 2){
				if(current.leftChild.balanceFactor() == -1){
					leftRight(current);
					current = current.parent;
				}else{
					leftLeft(current);
					current = current.parent;
				}
			}
			
			
			current = current.parent;
		}
		current.resetHeight();
	}

	
	public boolean inOrder(){
		ArrayList<K> checkArray = new ArrayList<K>();
		boolean returnVal = true;
		root.recursiveTraversal(checkArray);
		
		for(int i = 0; i < checkArray.size()-1; i++){
			if(checkArray.get(i).compareTo(checkArray.get(i+1)) > 0) returnVal = false;
		}
		return returnVal;
		
	}
	
	
	
	//Rebalancing Cases
	
	private void rightLeft(AVLNode current){
		AVLNode threeParent = current.parent;
		AVLNode threeNode = current;
		AVLNode fiveNode = current.rightChild;
		AVLNode fourNode = current.rightChild.leftChild;
		AVLNode CNode = current.rightChild.leftChild.rightChild;
		
		
		threeNode.rightChild = fourNode;
		fourNode.parent = threeNode;
		
		fourNode.rightChild = fiveNode;
		fiveNode.parent = fourNode;
		
		if(CNode != null){
			fiveNode.leftChild = CNode;
			CNode.parent = fiveNode;
			}else{
				fiveNode.leftChild = null;
			}
		
		rightRight(threeNode);
	}
	
	private void leftLeft(AVLNode current){
		AVLNode fiveParent = current.parent;
		AVLNode fiveNode = current;
		AVLNode fourNode = current.leftChild;
		//AVLNode threeNode = current.leftChild.leftChild;
		AVLNode CNode = current.leftChild.rightChild;
		
		if(isRightChild(current)){
			fiveParent.rightChild = fourNode;
		}else{
			fiveParent.leftChild = fourNode;
		}
		fourNode.parent = fiveParent;
		
		
		if(CNode != null){
			fiveNode.leftChild = CNode;
			CNode.parent = fiveNode;
			}else{
				fiveNode.leftChild = null;
			}
		
		
		fourNode.rightChild = fiveNode;
		fiveNode.parent = fourNode;

	}
	private void rightRight(AVLNode current){
		AVLNode threeParent = current.parent;
		AVLNode threeNode = current;
		AVLNode fourNode = current.rightChild;
		//AVLNode fiveNode = current.rightChild.rightChild;
		AVLNode BNode = current.rightChild.leftChild;
		
		if(isRightChild(current)){
			threeParent.rightChild = fourNode;
		}else{
			threeParent.leftChild = fourNode;
		}
		fourNode.parent = threeParent;
		
		if(BNode != null){
		threeNode.rightChild = BNode;
		BNode.parent = threeNode;
		}else{
			threeNode.rightChild = null;
		}
		
		fourNode.leftChild = threeNode;
		threeNode.parent = fourNode;
	}
	private void leftRight(AVLNode current){
		AVLNode fiveParent = current.parent;
		AVLNode fiveNode = current;
		AVLNode threeNode = current.leftChild;
		AVLNode fourNode = current.leftChild.rightChild;
		AVLNode BNode = current.leftChild.rightChild.leftChild;
		
		
		fiveNode.leftChild = fourNode;
		fourNode.parent = fiveNode;
		
		fourNode.leftChild = threeNode;
		threeNode.parent = fourNode;
		
		if(BNode != null){
			threeNode.rightChild = BNode;
			BNode.parent = threeNode;
			}else{
				threeNode.rightChild = null;
			}
		
		leftLeft(fiveNode);
	}
	
	private boolean isRightChild(AVLNode current){
		
		return current.parent.rightChild == current;
	}
	/*
	 * Returns the value associated with the given key in this binary search tree.
	 * If there is no element associated with this key, null is returned.
	 */
	public V get(K key) {
		if(root == null){
			return null;
		}
		return root.recursiveGet(key);
	}


	/*
	 * Clears all elements from the tree.
	 */
	public void clear() {
		root = null;
	}

	private class AVLNode {
		public K key;
		public V value;
		public AVLNode leftChild = null;
		public AVLNode rightChild = null;
		public AVLNode parent = null;
		public int height = 1;
		// null key will generate a null pointer exception when 
		// a method (such as compareTo) is called on it. 
		// This is matches the Java Collections Framework specification.
		public AVLNode(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		private void recursiveTraversal(ArrayList<K> arr){
			if(leftChild != null){
				leftChild.recursiveTraversal(arr);
				arr.add(key);
			}else{
				arr.add(key);
			}
			if(rightChild != null){
				rightChild.recursiveTraversal(arr);
			}
		}

		public void resetHeight(){
			if(this.rightChild == null && this.leftChild ==null){
				this.height = 1;
			}
			else if (this.rightChild == null){
				this.height = this.leftChild.height + 1;
			} 
			else if(this.leftChild == null){
				this.height = this.rightChild.height + 1;
			}
			else{
				this.height = Math.max(this.leftChild.height, this.rightChild.height) + 1;
			}
		}

		public int balanceFactor(){
			if(this.rightChild == null && this.leftChild ==null){
				return 0;
			}
			else if(this.rightChild == null){
				return this.leftChild.height;
			}else if(this.leftChild == null){
				return 0 - this.rightChild.height;
			}else{
				return this.leftChild.height - this.rightChild.height;
			}
		}

		public V recursiveGet(K key){
			if(this.key == key){
				return this.value;
			}
			if(key.compareTo(this.key) < 0){
				if(leftChild == null){
					return null;
				}else{
					return leftChild.recursiveGet(key);
				}
			}else{

				if(rightChild == null){
					return null;
				}else{
					return rightChild.recursiveGet(key);
				}
			}

		}
	}
}