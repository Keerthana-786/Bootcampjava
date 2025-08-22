import java.util.*;
public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Ask user to enter a sentence with mixed formatting
        System.out.println("Enter a sentence with mixed formatting:");
        String input = scanner.nextLine();
        // 1. trim() - Remove extra spaces
        input = input.trim();
        // 2. replace() - Replace all spaces with underscores
        String replacedSpaces = input.replace(" ", "_");
        // 3. replaceAll() - Remove all digits using regex
        String noDigits = replacedSpaces.replaceAll("\\d", "");
        // 4. split() - Split sentence into words array (avoid empty elements)
        String[] words = noDigits.split("_+");
        // 5. join() - Rejoin words with " | " separator
        String joined = String.join(" | ", words);
        System.out.println("\n=== Basic Processing ===");
        System.out.println("Original (trimmed): " + input);
        System.out.println("Spaces replaced: " + replacedSpaces);
        System.out.println("Digits removed: " + noDigits);
        System.out.println("Words array: " + Arrays.toString(words));
        System.out.println("Joined with | : " + joined);
        // Additional processing
        System.out.println("\n=== Additional Processing ===");
        String noPunctuation = removePunctuation(input).replaceAll("\\d+", "");
        System.out.println("No punctuation: " + noPunctuation);
        String capitalized = capitalizeWords(noPunctuation);
        System.out.println("Capitalized: " + capitalized);
        String reversedOrder = reverseWordOrder(noPunctuation);
        System.out.println("Reversed word order: " + reversedOrder);
        System.out.println("\nWord Frequency:");
        countWordFrequency(noPunctuation);
        scanner.close();
    }
    // Method to remove punctuation
    public static String removePunctuation(String text) {
        return text.replaceAll("\\p{Punct}", "");  // Removes all punctuation
    }
    // Method to capitalize each word
    public static String capitalizeWords(String text) {
        String[] words = text.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            if (!w.isEmpty()) {
                sb.append(Character.toUpperCase(w.charAt(0)))
                  .append(w.substring(1).toLowerCase())
                  .append(" ");
            }
        }
        return sb.toString().trim();
    }

    // Method to reverse word order
    public static String reverseWordOrder(String text) {
        String[] words = text.split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    // Method to count word frequency
    public static void countWordFrequency(String text) {
        String[] words = text.toLowerCase().split("\\s+");
        Map<String, Integer> freqMap = new LinkedHashMap<>();
        for (String w : words) {
            if (!w.isEmpty()) {
                freqMap.put(w, freqMap.getOrDefault(w, 0) + 1);
            }
        }
        freqMap.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}
