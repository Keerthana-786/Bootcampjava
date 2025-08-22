import java.util.*;
public class SpellChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Dictionary
        String[] dictionary = {"apple", "orange", "banana", "grape", "fruit", "mango"};
        System.out.println("Enter a sentence:");
        String sentence = sc.nextLine();
        String[] words = splitWords(sentence);
        System.out.printf("%-15s %-15s %-10s %-10s%n", "Word", "Suggestion", "Distance", "Status");
        for (String word : words) {
            String suggestion = findClosest(word, dictionary);
            if (suggestion.equals(word)) {
                System.out.printf("%-15s %-15s %-10s %-10s%n", word, "-", "-", "Correct");
            } else {
                int dist = stringDistance(word, suggestion);
                System.out.printf("%-15s %-15s %-10d %-10s%n", word, suggestion, dist, "Misspelled");
            }
        }
    }
    static String[] splitWords(String text) {
        List<String> list = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (!Character.isLetter(c)) {
                if (start < i) list.add(text.substring(start, i));
                start = i + 1;
            }
        }
        if (start < text.length()) list.add(text.substring(start));
        return list.toArray(new String[0]);
    }
    static int stringDistance(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i <= a.length(); i++) dp[i][0] = i;
        for (int j = 0; j <= b.length(); j++) dp[0][j] = j;
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        return dp[a.length()][b.length()];
    }
    static String findClosest(String word, String[] dict) {
        String closest = word;
        int minDist = Integer.MAX_VALUE;
        for (String d : dict) {
            int dist = stringDistance(word, d);
            if (dist < minDist) {
                minDist = dist;
                closest = d;
            }
        }
        return (minDist <= 2) ? closest : word;
    }
}
