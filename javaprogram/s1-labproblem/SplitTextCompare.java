import java.util.Scanner;
public class SplitTextCompare {
 public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Stop when exception occurs
        }
        return count;
    }
    public static String[] customSplit(String text) {
        int length = findLength(text);
        int wordCount = 1; 
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }
        String[] words = new String[wordCount];
        String currentWord = "";
        int index = 0;
        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            if (ch == ' ') {
                words[index++] = currentWord;
                currentWord = "";
            } else {
                currentWord += ch;
            }
        }
        words[index] = currentWord;
        return words;
    }
    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();
        String[] customWords = customSplit(input);
        String[] builtInWords = input.split(" ");
        // Compare results
        boolean areSame = compareArrays(customWords, builtInWords);
        // Display results
        System.out.println("\nCustom Split Result:");
        for (String word : customWords) {
            System.out.println(word);
        }
        System.out.println("\nBuilt-in Split Result:");
        for (String word : builtInWords) {
            System.out.println(word);
        }
        System.out.println("\nAre both results same? " + areSame);
        sc.close();
    }
}
