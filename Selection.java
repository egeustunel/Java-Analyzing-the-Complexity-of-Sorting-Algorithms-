import java.util.ArrayList;

public class Selection {
	public static void SelectionSort(ArrayList<ArrayList<String>> dataset, int column) {
		ArrayList<String> tempList = new ArrayList<String>();
		for (int i = 1; i < dataset.size() - 1; i++) {
			tempList.clear();
			int index = i;
			for (int j = i + 1; j < dataset.size(); j++) {
				if (Float.parseFloat(dataset.get(j).get(column)) < Float.parseFloat(dataset.get(index).get(column))) {
					index = j;// searching for lowest index
				}
			}
			for (int j = 0; j < dataset.get(0).size(); j++) {
				tempList.add(dataset.get(index).get(j));
			}
			
			for (int j = 0; j < dataset.get(0).size(); j++) {
				//String smallerNumber = dataset.get(index).get(j);
				dataset.get(index).set(j, dataset.get(i).get(j));
				dataset.get(i).set(j, tempList.get(j));
			}

		}

	}
}