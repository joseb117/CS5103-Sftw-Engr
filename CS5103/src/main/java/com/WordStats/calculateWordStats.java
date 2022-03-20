package com.WordStats;

import java.util.HashMap;

public class calculateWordStats {
	HashMap<String, Integer> words = new HashMap<String, Integer>();
	
	public void analyzeDocument(String line)
	{
		//begin parsing the line of words retrieved from the document
		String text[] = line.split("\\W+");
		
		for(String s: text)
		{
			//if the word is new add it to the hashmap, otherwise update the hashmap with the new count
			if(words.containsKey(s))
			{
				words.put(s, 1);
			}
			else
			{
				words.put(s, words.get(s)+1);
			}
		}
	}

}
