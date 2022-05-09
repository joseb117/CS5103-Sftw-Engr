To run this code, the WordStats. java file needs to be built as a java application and then ran. It will ask for user input such as the document name and the words that 
would like to be replaced along with the word to be substituted. Additionally, the keyword that the user would like line numbers to be returned for.

Ultimately, This project consists of 2 classes: WordStats.java and calculateWordStats.java along with a test class called calculateWordStatsTest.java.
The WordStats.java file contains the main method which reads from a file and calculates statistics based off given words from user input.
The calculateWordStats class gets called to do those calculations. There a 3 methods within this class. One, called analyzeDocument parses the text
document line by line and checks whether words are found, if they are if adds them to a hashmap and keeps count of how many there are. Once complete, the method returns the 
stats to the user. Grepline was a new method added later on that takes a filename and a keyword, whcih it then uses to check if a line in the document has the word. If
it does it returns the line number it was found in. The last method is displayMap which is used in the analyzeDocument method to display the hashmap statistics.