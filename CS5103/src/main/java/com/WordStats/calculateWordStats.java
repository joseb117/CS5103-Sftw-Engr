package com.WordStats;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class calculateWordStats {
	HashMap<String, Integer> words = new HashMap<String, Integer>();
	String outputTxt = "";
	int lineNum = 1;
	//function used to parse and analyze the text document line by line
	public void analyzeDocument(String line, String orig, String rpl, Scanner doc, String fileName)
	{
		//if the user provided replacement words then replace 
		if(orig != null && rpl != null && line.contains(orig))
		{
			line = line.replaceAll("(?<!\\S)"+orig+"(?!\\S)", rpl);
		}
		//begin parsing the line of words retrieved from the document
		String text[] = line.split("\\W+");
		
		for(String s: text)
		{
			//if the word is new add it to the hashmap, otherwise update the hashmap with the new count
			if(!words.containsKey(s))
			{
				words.put(s, 1);
			}
			else
			{
				words.put(s, words.get(s)+1);
			}
			
		}
		outputTxt += line + '\n';
		if(!doc.hasNextLine())
		{
			try {
				FileWriter fw = new FileWriter("C:\\Users\\joseb\\OneDrive\\Documents\\GitHub\\CS5103-Sftw-Engr\\CS5103\\src\\main\\resources\\" + fileName);
				System.out.println("Writing to file...");
				fw.write(outputTxt);
				fw.close();
			} catch (IOException e) {
				System.out.println("Error Writing to File");
				e.printStackTrace();
			}
		}
	}
	
	//grepline function for third requirement
	//takes document name and keyword as input. Returns line of document where keyword matches
	void grepLine(String fileName, String keyword, String line)
	{
		boolean appears = false;
		//begin parsing the line of words retrieved from the document
		String text[] = line.split("\\W+");
		
		
		for(String s: text)
		{
			if(s.equals(keyword))
			{
				appears = true;
			}
		}
		
		//return whether the keyword appears
		if(appears == true)
		{
			System.out.println(keyword + " appears in line: " + lineNum);
		}
		lineNum++;
	}
	
	
	//function that prints the words and their counts
	public void displayMap(HashMap<String, Integer> map)
	{
		System.out.println("The word counts for the text document are:");
		for(String k: map.keySet())
		{
			System.out.println(k + " = " + map.get(k));
		}
	}
}
