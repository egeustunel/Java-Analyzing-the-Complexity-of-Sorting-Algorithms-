import java.util.ArrayList;

public class Quicksort {

	/*
	 * This function takes last element as pivot, places the pivot element at its
	 * correct position in sorted array, and places all smaller (smaller than pivot)
	 * to left of pivot and all greater elements to right of pivot
	 */
	public static int partition(ArrayList<ArrayList<String>> dataset, int low, int high, int column) {
		ArrayList<String> tempList = new ArrayList<String>();
		float pivot = Float.parseFloat(dataset.get(high).get(column));
		int i = (low - 1); // index of smaller element
		for (int j = low; j < high; j++) {
			// If current element is smaller than or
			// equal to pivot
			if (Float.parseFloat(dataset.get(j).get(column)) <= pivot) {
				i++;

				// swap arr[i] and arr[j]
				
				tempList.clear();
				for (int j2 = 0; j2 < dataset.get(0).size(); j2++) {
					tempList.add(dataset.get(i).get(j2));
				}
				
				
				//String temp = dataset.get(i).get(7);
				for (int j2 = 0; j2 < dataset.get(0).size(); j2++) {
					dataset.get(i).set(j2, dataset.get(j).get(j2));
					dataset.get(j).set(j2, tempList.get(j2));
				}
				
			}
		}

		// swap arr[i+1] and arr[high] (or pivot)
		
		tempList.clear();
		
		for (int j = 0; j < dataset.get(0).size(); j++) {
			tempList.add(dataset.get(i+1).get(j));
		}
		
		for (int j = 0; j < dataset.get(0).size(); j++) {
			dataset.get(i + 1).set(j, dataset.get(high).get(j));
			dataset.get(high).set(j, tempList.get(j));
		}
		//String temp = dataset.get(i + 1).get(7);
		

		return i + 1;
	}

	/*
	 * The main function that implements QuickSort() arr[] --> Array to be sorted,
	 * low --> Starting index, high --> Ending index
	 */
	public static void sort(ArrayList<ArrayList<String>> dataset, int low, int high, int column) {
		if (low < high) {
			/*
			 * pi is partitioning index, arr[pi] is now at right place
			 */
			int pi = partition(dataset, low, high, column);

			// Recursively sort elements before
			// partition and after partition
			sort(dataset, low, pi - 1, column);
			sort(dataset, pi + 1, high, column);
		}
	}
}