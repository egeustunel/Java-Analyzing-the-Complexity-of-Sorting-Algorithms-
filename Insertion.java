import java.util.ArrayList;

public class Insertion {
	public static void insertionSort(ArrayList<ArrayList<String>> dataset, int column) {
		ArrayList<String> tempList = new ArrayList<String>();

		for (int j = 1; j < dataset.size(); j++) {
			tempList.clear();
			for (int i = 0; i < dataset.get(0).size(); i++) {
				tempList.add(dataset.get(j).get(i));
			}
			Float key = Float.parseFloat(dataset.get(j).get(column));

			int i = j - 1;
			while ((i > 0) && (Float.parseFloat(dataset.get(i).get(column)) > key)) {

				for (int k = 0; k < dataset.get(0).size(); k++) {
					dataset.get(i + 1).set(k, dataset.get(i).get(k));
				}

				i--;
			}
			for (int k = 0; k < dataset.get(0).size(); k++) {
				dataset.get(i + 1).set(k, tempList.get(k));
			}

		}

	}
}
