package baitap1;

import java.util.ArrayList;

public class Process {
	// upperToLower and delete space
	public ArrayList<String> upperToLowerDeleteSpace(ArrayList<String> listLines) {
		ArrayList<String> listResult = new ArrayList<String>();
		for (String line : listLines) {
			String tmp = line.trim().replaceAll("\\s+", " ");
			listResult.add(tmp.toLowerCase());
		}
		return listResult;
	}

	// delete regex
	public ArrayList<String> removeRegex(ArrayList<String> listLines) {
		ArrayList<String> listResult = new ArrayList<String>();
		for (String line : listLines) {
			char tmp[] = line.toCharArray();
			for (char c : tmp) {
				if (isRegex(c)) {
					line = line.replace(Character.toString(c), "");
				}
			}
			listResult.add(line);
		}
		return listResult;
	}

	//delete stopword
	public ArrayList<String> removeStopWord(ArrayList<String> listLines, ArrayList<String> listStopWord) {
		ArrayList<String> listResult = new ArrayList<String>();
		for (String line : listLines) {
			for (String stopword : listStopWord) {
				line = line.replaceAll(stopword + " ", "");
				line = line.replaceAll(" " + stopword, "");
			}
			listResult.add(line);
		}
		return listResult;
	}

	public boolean isRegex(char c) {
		int asciiValue = (int) c;

		if (asciiValue == 32 || (asciiValue >= 48 && asciiValue <= 57) || (asciiValue >= 65 && asciiValue <= 90)
				|| (asciiValue >= 97 && asciiValue <= 122)) {
			return false;
		}
		return true;
	}
}
