import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

public class UniqueWordCounter {
    public static int countUniqueWords(String inputFilePath, String outputFilePath) {
        try {
            // Read the contents of the input file into a string
            String fileContents = FileUtils.readFileToString(new File(inputFilePath), "UTF-8");

            // Split the file contents into words
            String[] words = StringUtils.split(fileContents);

            // Create a set to store the unique words
            Set<String> uniqueWords = new HashSet<>();

            // Add each word to the set
            for (String word : words) {
                uniqueWords.add(word);
            }

            // Get the number of unique words
            int uniqueWordCount = uniqueWords.size();

            // Write the number of unique words to the output file
            FileUtils.writeStringToFile(new File(outputFilePath), "Unique word count: " + uniqueWordCount, "UTF-8");

            // Return the number of unique words
            return uniqueWordCount;
        } catch (IOException e) {
            System.err.println("Error reading or writing file: " + e.getMessage());
            return -1;
        }
    }
}
