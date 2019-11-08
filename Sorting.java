//Name: Nicholas Drazso  
//Date: April 3, 2019
//Program Description: Various sorting algorithms 

public class Sorting {

	public static void main (String[] args) {
		
		int[] n = {1, 4, 4, 4, 4, 3};
		
		MergeSort(n, 0, 5);
		
		for (int i = 0; i < n.length; i++) {
			System.out.println(n[i]);
		}
		
	}
	
	
	
	public static void insertionSort(String[] words) {


		String key;

		//Loops through all words except first index since it is assumed to be sorted
		for (int i = 1; i < words.length; i++) {

			//Set the pointer at the second element
			key = words[i];

			//Secondary pointer to check element previous
			int j = i - 1;

			//When a swap needs to be made make it, and keep swapping backwards into sorted array until everything is in proper order
			while (j >= 0 && words[j].compareTo(words[j + 1]) > 0) {
				words[j + 1] = words[j];
				j--;
				words[j + 1] = key;

			}

		}

	}


	public static void selectionSort(int[] numbers) {

		//go through entire array except final element since second for loop accounts for i + 1
		for (int i = 0; i < numbers.length - 1; i++) {

			//Sets min at first position
			int min = i;

			//Starting at one spot over from the i pointer, check for the smallest index in the rest of the array
			for (int j = i + 1; j < numbers.length; j++) {

				//Saves new smallest index and keeps over writing until the end of the array
				if (numbers[j] < numbers[min]) 
					min = j;
			}

			//i pointer and minimum swap positions
			int temp = numbers[i];
			numbers[i] = numbers[min];
			numbers[min] = temp;
		}

	}

	
	public static void Merge(int[] A, int lo, int mid, int hi) {

		//Determines sizes of temporary arrays
		int sizeLeft = (mid - lo) + 1;
		int sizeRight = hi - mid;

		//Creating temporary arrays 
		int[] l = new int[sizeLeft];
		int[] r = new int[sizeRight];

		//Copies parameters indexes into temporary arrays
		for (int i = 0; i < sizeLeft; i++) 
			l[i] = A[lo + i];

		for (int i = 0; i < sizeRight; i++) 
			r[i] = A[mid + 1 + i];

		//n is a pointer for the original array, x is the pointer for the left side of the sub array, y is the pointer for the right side of the sub array
		int n = lo, x = 0, y = 0;

		//Inserts smallest element into array
		while (x < sizeLeft && y < sizeRight) {
			
			//Copies element from left sub array into original array since it is smaller than the corresponding element in the right, also increases the pointer by 1 for the left sub array
			if (l[x] <= r[y]) {
				A[n] = l[x];
				x++;
			}

			//Otherwise element from right sub array must be bigger so copy it into original array
			else {
				A[n] = r[y];
				y++;
			}

			//Increase original arrays pointer 
			n++;
		}

		//Copy the remaining of left side since right side is done
		while (x < sizeLeft) {
			A[n] = l[x];
			x++;
			n++;

		}

		//Copy the remaining of right side since left side is done
		while (y < sizeRight) {
			A[n] = r[y];
			y++;
			n++;

		}



	}

	
	public static void MergeSort(int[] A, int lo, int hi) {

		//Computes middle index
		int mid = (hi + lo) / 2;

		//Recursively splits given array in half until sub arrays of size 1 exist, then merge them together to sort
		if (lo < hi) {
			MergeSort(A, lo, mid);
			MergeSort(A, mid + 1, hi);
			Merge(A, lo, mid, hi);

		}


	}


}