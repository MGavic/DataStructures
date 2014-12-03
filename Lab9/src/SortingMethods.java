//Thomas Hagen, Myles Gavic

/*
 * Add a static quickSort method to your SortingMethods class (starter code for the method below).
 *  Note: For Part 2, you will need the mergeSort method you wrote last week.
 *  If you need a refresher on how QuickSort works, the textbook provides pseudocode and examples on pp. 533-540.
 *  Do not use the textbook's Java implementation that starts on p. 540 - among other things, it uses a different type system than we are using.
 *  You may also find the wikipedia QuickSort page useful.\
 *  Choose your pivot to be the first value in the (sub)array you are sorting.
 *  Write a TestQuickSort.java file that ensures that your QuickSort implementation is working.
 *  You may use jUnit or a class with a main method.
 *  This should parallel the tests in TestSorting.java, but remember that QuickSort is not a stable sort.

 */



public class SortingMethods {
	//counts how many time a sorting method is run
	static long comparisonCount = 0;

	public static void insertionSort(Comparable[] arr) {

		for (int i = 1; i < arr.length; i++) {
			Comparable nextItem = arr[i];

			int j = i;
			while (j > 0 && nextItem.compareTo(arr[j - 1]) < 0) {
				comparisonCount++;
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = nextItem; 
		}
	}




	public static void mergeSort(Comparable[] arr) {


		if(arr.length <= 1) {
			return;
		}
		/* This creates the two new arrays that are needed at each call of mergeSort.
		 * Creating Comparable arrays and then casting them to T arrays is a bit of a 
		 * hack, but it works.
		 */
		Comparable[] leftHalf = new Comparable[arr.length / 2];
		Comparable[] rightHalf = new Comparable[arr.length - leftHalf.length];
		//For Loop for leftHalf
		for (int j = 0; j < arr.length / 2; j++) {
			leftHalf[j] = arr[j];
		}
		//For Loop for RightHalf
		for (int i = leftHalf.length; i < arr.length; i++) {
			rightHalf[i - leftHalf.length] = arr[i];
		}

		SortingMethods.mergeSort(leftHalf);
		SortingMethods.mergeSort(rightHalf);

		int i = 0;
		int j = 0;
		int k = 0;


		while (i < leftHalf.length && j < rightHalf.length) {
			comparisonCount++;
			if (leftHalf[i].compareTo(rightHalf[j]) <= 0) {

				arr[k] = leftHalf[i];

				i++;
				k++;
			}else{

				arr[k] = rightHalf[j];

				j++;
				k++;
			}


		}
		while (i < leftHalf.length) {
			arr[k] = leftHalf[i++];
			//add all values from left half to arr
			k++;
		}
		while (j < rightHalf.length) {
			arr[k] = rightHalf[j++];
			//add all values from right half to arr
			k++;
		}
	}









	/* Public method that can be called with just an array */
	public static <T extends Comparable<T>> void quickSort(T[] arr) {

		quickSortRecursive(arr, 0, arr.length - 1) ;
	}

	// Private method that can be called recursively
	private static <T extends Comparable<T>> void quickSortRecursive(T[] arr, int left, int right) {

		if(right <= left){
			return;
		}

		// Step 1: set up swap pointer index
		int swapPointer = left;
		int currentPointer = left;
		T pivot = arr[left]; 


		// Step 2: swap pivot with the last value in the subarray */
		swapper(arr, left, right);

		// Step 3: partition (hint: you'll need a loop)
		while(currentPointer < right){
			comparisonCount++;
			if(arr[currentPointer].compareTo(pivot) > 0){
				currentPointer++;
			}else{
				swapper(arr, swapPointer, currentPointer);
				currentPointer++;
				swapPointer++;
			}
		}
		swapper(arr, swapPointer, right);

		// Step 4: Make the recursive calls

		quickSortRecursive(arr, left, swapPointer - 1);
		quickSortRecursive(arr, swapPointer + 1, right);


	}
	private static <T extends Comparable<T>> void swapper(T[] array, int swap, int current){
		T swapHolder = array[swap];
		array[swap] = array[current];
		array[current] = swapHolder;

	}
}


