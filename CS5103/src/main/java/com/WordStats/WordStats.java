/*
 * Author: Jose Burnias
 * CS5103 - Software Engineering
 * Program to calculate different statistics of unique words within a text document
 */
package com.WordStats;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordStats {

	public static void main(String[] args) {
		calculateWordStats calc = new calculateWordStats();
		String fileName = null;
		//try to read from the file and catch an exception if the file is not found
		try {
			Scanner scan = new Scanner(System.in);
			fileName = scan.nextLine();
			File doc = new File("C:\\Users\\joseb\\Documents\\workspace-sts-3.9.11.RELEASE\\CS5103\\src\\main\\resources\\" + fileName);
			Scanner s = new Scanner(doc);
			while(s.hasNextLine())
			{
				//get the first line of the document and begin parsing the words
				String line = s.nextLine();
				
				//the function call to calculate the document's word occurrences
				calc.analyzeDocument(line);
			}
			s.close();
		} catch(FileNotFoundException e) {
			System.out.println("Error opening the file: " + fileName);
			e.getStackTrace();
		}

	}

}
