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
		String decision = null;
		String rplWord = null;
		String origWord = null;
		//try to read from the file and catch an exception if the file is not found
		try {
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter the filename: ");
			fileName = scan.nextLine();
			
			//ask the user if they want to replace any of the words with one of their choice
			System.out.print("Would you like to replace a word? - Enter 0 (Yes) or 1 (No): ");
			decision = scan.nextLine();
			while((!decision.equals("0")) && (!decision.equals("1")))
			{
				System.out.print("Would you like to replace a word? - Enter 0 (Yes) or 1 (No): ");
				decision = scan.nextLine();
			}
			
			//word replacement conditions
			if(decision.equals("0"))
			{
				//ask for the replacement words
				System.out.print("Type the word you want to replace: ");
				origWord = scan.nextLine();
				System.out.print("Type the word you want to replace it with: ");
				rplWord = scan.nextLine();
			}
			else
			{
				System.out.println("No words were chosen to replace, working on word counts....");
			}
			
			File doc = new File("C:\\Users\\joseb\\OneDrive\\Documents\\GitHub\\CS5103-Sftw-Engr\\CS5103\\src\\main\\resources\\" + fileName);
			Scanner s = new Scanner(doc);
			while(s.hasNextLine())
			{	
				//get the first line of the document and begin parsing the words
				String line = s.nextLine();
				
				//the function call to calculate the document's word occurrences
				calc.analyzeDocument(line, origWord, rplWord, s, fileName);
			}
			
			//display the word counts from the text document
			calc.displayMap(calc.words);
			s.close();
		} catch(FileNotFoundException e) {
			System.out.println("Error opening the file: " + fileName);
			e.getStackTrace();
		}
	}
}
