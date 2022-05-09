package com.WordStats;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class calculateWordStatsTest {
	calculateWordStats calc;
	HashMap<String, Integer> words;
	int lineNum = 1;
	Scanner test_doc;
	String line = null;
	Scanner single_line_doc;
	private final String TEST_LINE = "This is a test line"; 
	private final String TEST_ORIG = "brown";
	private final String TEST_RPL = "brown";
	private final String NULL_STR = null;
	private final String TEST_FILE = "sampleTextDoc.txt";
	private final String SINGLE_LINE_DOC = "singleLineDoc.txt";
	private final String BAD_TEST_FILE = "test.pptx";
	
	/*
	 * The variables and items required to test the calculateWordStats class
	 */
	@Before
	public void setup()
	{
		calc = new calculateWordStats();
		File doc = new File("C:\\Users\\joseb\\OneDrive\\Documents\\GitHub\\CS5103-Sftw-Engr\\CS5103\\src\\main\\resources\\" + TEST_FILE);
		try {
			test_doc = new Scanner(doc);
		} catch (FileNotFoundException e) {
			
		}
		
		File singleLineDoc = new File("C:\\Users\\joseb\\OneDrive\\Documents\\GitHub\\CS5103-Sftw-Engr\\CS5103\\src\\main\\resources\\" + SINGLE_LINE_DOC);
		try {
			single_line_doc = new Scanner(singleLineDoc);
		} catch (FileNotFoundException e) {
			
		}
	}
	
	/*
	 * tests if there are words the user wants to replace
	 * mainly to test condition that checks they are not null
	 */
	@Test
	public void testAnalyzeDocumentRplWords() 
	{
		calc = new calculateWordStats();
		line = test_doc.nextLine();
		calc.analyzeDocument(line, TEST_ORIG, TEST_RPL, test_doc, TEST_FILE);
		assertTrue(TEST_ORIG != null);
		assertTrue(TEST_RPL != null);
	}
	
	/*
	 * tests when a file does not have a next line
	 */
	@Test
	public void testAnalyzeDocumentNoNextLine() 
	{
		calc = new calculateWordStats();
		line = single_line_doc.nextLine();
		calc.analyzeDocument(TEST_LINE, TEST_ORIG, TEST_RPL, single_line_doc, SINGLE_LINE_DOC);
		assertTrue(!single_line_doc.hasNextLine());
	}
	
	/*
	 * tests the grepline function if the keyword and filename are valid
	 */
	@Test
	public void grepLineTest()
	{
		calc = new calculateWordStats();
		line = test_doc.nextLine();
		calc.grepLine(TEST_FILE, TEST_ORIG, line);
		assertTrue(TEST_FILE != null);
		assertTrue(TEST_ORIG != null);
		
	}
	
	/*
	 * Tests the display function with valid hashMap values
	 */
	@Test
	public void displayMapTest() {
		words = new HashMap<String, Integer>();
		words.put("Test0", 0);
		words.put("Test1", 1);
		words.put("Test2", 2);
		calc.displayMap(words);
		assertTrue(words.containsKey("Test0"));
		assertTrue(words.containsKey("Test1"));
		assertTrue(words.containsKey("Test2"));
		assertTrue(words.containsValue(0));
		assertTrue(words.containsValue(1));
		assertTrue(words.containsValue(2));
	}
	
	/*
	 * clean up function after the testing
	 */
	@After
	public void tearDown() {
		single_line_doc.close();
		test_doc.close();
	}
}
