import java.util.Arrays;
import java.util.Random;


public class CompareSortingMethods {

	public static void main(String[] args) {
		Integer[] largeArray1 = randomInts(0, 100000, 100000);

		Integer[] largeArray2 = randomInts(0, 100000, 100000);//Arrays.copyOf(largeArray1, largeArray1.length);
		Integer[] largeArray3 = randomInts(0, 100000, 100000);//Arrays.copyOf(largeArray1, largeArray1.length);

		String[] stringArray1 = randomStrings(100000);
		

		long startTime;
		long timeElapsed;


		//Insertion Sort
		SortingMethods.comparisonCount = 0;

		startTime = System.currentTimeMillis();
		//SortingMethods.insertionSort(largeArray1);
		timeElapsed = System.currentTimeMillis() - startTime;

		System.out.println(SortingMethods.comparisonCount);
		System.out.println(timeElapsed);


		//Merge Sort
		SortingMethods.comparisonCount = 0;

		startTime = System.currentTimeMillis();
		SortingMethods.mergeSort(largeArray2);
		timeElapsed = System.currentTimeMillis() - startTime;

		System.out.println(SortingMethods.comparisonCount);
		System.out.println(timeElapsed);


		//Quick Sort
		SortingMethods.comparisonCount = 0;

		startTime = System.currentTimeMillis();
		SortingMethods.quickSort(largeArray3);
		timeElapsed = System.currentTimeMillis() - startTime;

		System.out.println(SortingMethods.comparisonCount);
		System.out.println(timeElapsed);



		

		//Insertion Sort String
		SortingMethods.comparisonCount = 0;

		startTime = System.currentTimeMillis();
		//SortingMethods.insertionSort(stringArray1);
		timeElapsed = System.currentTimeMillis() - startTime;

		System.out.println(SortingMethods.comparisonCount);
		System.out.println(timeElapsed);


		//Merge Sort String
		SortingMethods.comparisonCount = 0;

		startTime = System.currentTimeMillis();
		SortingMethods.mergeSort(stringArray1);
		timeElapsed = System.currentTimeMillis() - startTime;

		System.out.println(SortingMethods.comparisonCount);
		System.out.println(timeElapsed);



		//Quick Sort String
		SortingMethods.comparisonCount = 0;

		startTime = System.currentTimeMillis();
		SortingMethods.quickSort(stringArray1);
		timeElapsed = System.currentTimeMillis() - startTime;

		System.out.println(SortingMethods.comparisonCount);
		System.out.println(timeElapsed);


		
	}

	/*
	 * Generates an array of random Integers in the range from 
	 * min (inclusive) to max (exclusive). The number of elements 
	 * is given by num. 
	 *
	 * throws IllegalArgumentException if min >= max or num < 0
	 */
	public static Integer[] randomInts(int min, int max, int num) {
		if (min >= max || num < 0) {
			throw new IllegalArgumentException();
		}
		Integer [] theInts = new Integer[num];
		Random rand = new Random();
		for (int i = 0; i < num; ++i){
			theInts[i] = rand.nextInt(max - min) + min;			
		}
		return theInts;
	}


	public static String[] randomStrings(int num) {
		String [] theStrings = new String[num];


		for (int i = 0; i < num; ++i){
			Random rand = new Random();
			long characterNumber = rand.nextInt(100) +1;
			String returnString = "";

			for(int j = 0; j < characterNumber; j++){
				Random rand2 = new Random();

				char characterLetter = (char) (rand2.nextInt(26) + 'a');

				returnString = returnString + characterLetter;
			}

			theStrings[i] = returnString;


		}
		return theStrings;
	}
}
