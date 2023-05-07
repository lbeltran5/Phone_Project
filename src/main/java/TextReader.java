// importing necessary libraries
import java.util.HashSet;
import java.util.Set;

// importing class from Apache it provides set utilities to work with 'String'
import org.apache.commons.lang3.StringUtils;

public class TextReader {
    private final String text;

    public TextReader(String text) {
        this.text = text;
    }

    public int countUniqueWords() {
        // creating a HashSet to store the unique words in the text
        Set<String> uniqueWords = new HashSet<>();

        // Split the text into words using the StringUtils.split() method
        // This method splits the text into an array of words based on whitespace
        String[] words = StringUtils.split(text);

        // Iterate over each word in the array of words
        for (String word : words) {
            // Add each word to the HashSet of unique words
            // Since a HashSet only stores unique values.
            // Any duplicate words will not be added.
            uniqueWords.add(word);
        }

        // Get the size of the HashSet, which will give us the number of unique words in the text
        int uniqueWordCount = uniqueWords.size();

        // Return the number of unique words in the text
        return uniqueWordCount;
    }

}
