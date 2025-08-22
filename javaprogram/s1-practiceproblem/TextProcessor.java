import java.util.*;

public class TextProcessor {

    // Clean and validate input
    public static String cleanInput(String input) {
        input = input.trim().replaceAll("\\s+", " ");
        return input;
    }

    // Analyze text: words, sentences, characters, longest word, most common char
    public static void analyzeText(String text) {
        String[] words = text.split("\\s+");
        int wordCount = words.length;
        int charCount = text.replace(" ", "").length();
        int sentenceCount = text.split("[.!?]").length;

        // Find longest word
        String longestWord = "";
        for (String word : words) {
            word = word.replaceAll("[^a-zA-Z]", "");
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        // Most common character
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : text.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
        }
        char mostCommonChar = ' ';
        int maxFreq = 0;
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > maxFreq) {
                mostCommonChar = entry.getKey();
                maxFreq = entry.getValue();
            }
        }

        System.out.println("\n=== TEXT ANALYSIS ===");
        System.out.println("Word Count: " + wordCount);
        System.out.println("Character Count (no spaces): " + charCount);
        System.out.println("Sentence Count: " + sentenceCount);
        System.out.println("Longest Word: " + longestWord);
        System.out.println("Most Common Character: '" + mostCommonChar + "' (" + maxFreq + " times)");
    }

    // Split text into words, remove punctuation, sort alphabetically
    public static String[] getWordsSorted(String text) {
        text = text.replaceAll("[^a-zA-Z ]", "");
        String[] words = text.split("\\s+");
        Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);
        return words;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== TEXT PROCESSOR ===");
        System.out.print("Enter a paragraph: ");
        String input = scanner.nextLine();

        // 1. Clean input
        String cleanedText = cleanInput(input);

        // 2. Analyze text
        analyzeText(cleanedText);

        // 3. Show words in alphabetical order
        String[] sortedWords = getWordsSorted(cleanedText);
        System.out.println("\nWords in Alphabetical Order:");
        for (String word : sortedWords) {
            System.out.print(word + " ");
        }
        System.out.println();

        // 4. Search for specific words
        System.out.print("\nEnter a word to search: ");
        String searchWord = scanner.nextLine().trim();
        boolean found = Arrays.asList(sortedWords).contains(searchWord);
        System.out.println("Word found: " + (found ? "Yes" : "No"));

        scanner.close();
    }
}
