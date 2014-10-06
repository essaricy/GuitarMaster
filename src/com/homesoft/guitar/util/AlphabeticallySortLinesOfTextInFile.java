package com.homesoft.guitar.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphabeticallySortLinesOfTextInFile {

	public void sort(String inputFile, String outputFile) throws Exception {
		FileReader fileReader = new FileReader(inputFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String inputLine;
		List<String> lineList = new ArrayList<String>();
		while ((inputLine = bufferedReader.readLine()) != null) {
			lineList.add(inputLine);
		}
		fileReader.close(); 

		Collections.sort(lineList);

		FileWriter fileWriter = new FileWriter(outputFile);
		PrintWriter out = new PrintWriter(fileWriter);
		for (String outputLine : lineList) {
			out.println(outputLine);
		}
		out.flush();
		out.close();
		fileWriter.close();
	}

	public static void main(String[] args) throws Exception {
		new AlphabeticallySortLinesOfTextInFile().sort("C:\\Users\\c997856\\Desktop\\work\\Issues\\LTCCAS\\PRD Logs Analysis\\searched_lines.txt", "C:\\Users\\c997856\\Desktop\\work\\Issues\\LTCCAS\\PRD Logs Analysis\\SORTED.txt");
	}

}
