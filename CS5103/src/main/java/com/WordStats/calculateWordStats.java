package com.WordStats;

import java.util.HashMap;

public class calculateWordStats {
	HashMap<String, Integer> words = new HashMap<String, Integer>();
	
	//function used to parse and analyze the text document line by line
	public void analyzeDocument(String line)
	{
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
