//Thomas Hagen, Myles Gavic
public class SortingMethods {


	public static void insertionSort(Comparable[] arr) {

		for (int i = 1; i < arr.length; i++) {
			Comparable nextItem = arr[i];

			int j = i;
			while (j > 0 && nextItem.compareTo(arr[j - 1]) < 0) {
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
