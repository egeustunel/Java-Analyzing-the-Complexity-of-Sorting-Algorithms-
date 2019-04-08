import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {

		String csvFile = args[0];
		int column = Integer.parseInt(args[1]) - 1;
		String save = args[2];
		BufferedReader br = null;
		String line = "";
		String csvSplitBy = ",";

		ArrayList<ArrayList<String>> dataset = new ArrayList<ArrayList<String>>();

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				
				String[] records = line.split(csvSplitBy);
				ArrayList<String> recordList = new ArrayList<String>();

				for (int k = 0; k < records.length; k++) {
					recordList.add(records[k]);
				}
				dataset.add(recordList);

			}
			 long tStart = System.nanoTime();
			 //Insertion.insertionSort(dataset, column);
			 //Selection.SelectionSort(dataset, column);
			 Quicksort.sort(dataset, 1, dataset.size() - 1, column);
			 long tEnd = System.nanoTime();
			 long tRes = tEnd - tStart; // time in nanoseconds
			 System.out.println("Elapsed time is: " + tRes + " nanoseconds");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if(save.equals("T")) {
			File file = new File(args[0]);//bunu düzeltt argüman pathi ver
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);

			for (int i = 0; i < dataset.size(); i++) {
				for (int j = 0; j < dataset.get(i).size(); j++) {
					bw.write(dataset.get(i).get(j) + ",");

				}
				bw.newLine();
			}

			bw.close();
			fw.close();
		}
		

	}

}
