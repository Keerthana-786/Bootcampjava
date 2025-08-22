import java.util.*;

public class TextFormatter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = sc.nextLine();
        System.out.println("Enter line width:");
        int width = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] words = splitWords(text);
        List<String> justifiedLines = justifyText(words, width);
        List<String> centeredLines = centerAlignText(words, width);

        System.out.println("\n=== Original Text ===");
        System.out.println(text);

        System.out.println("\n=== Left Justified Text ===");
        for (String line : justifiedLines) System.out.println(line);

        System.out.println("\n=== Center Aligned Text ===");
        for (String line : centeredLines) System.out.println(line);
    }

    // Split words without using split()
    static String[] splitWords(String text) {
        List<String> words = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                if (start < i) words.add(text.substring(start, i));
                start = i + 1;
            }
        }
        if (start < text.length()) words.add(text.substring(start));
        return words.toArray(new String[0]);
    }

    // Justify text
    static List<String> justifyText(String[] words, int width) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            int lineLength = words[i].length();
            int j = i + 1;
            while (j < words.length && lineLength + words[j].length() + (j - i) <= width) {
                lineLength += words[j].length();
                j++;
            }
            int gaps = j - i - 1;
            StringBuilder line = new StringBuilder();
            if (gaps == 0 || j == words.length) { // Left align
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) line.append(" ");
                }
                while (line.length() < width) line.append(" ");
            } else {
                int spaces = (width - lineLength) / gaps;
                int extra = (width - lineLength) % gaps;
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) {
                        for (int s = 0; s < spaces + (k - i < extra ? 1 : 0); s++)
                            line.append(" ");
                    }
                }
            }
            result.add(line.toString());
            i = j;
        }
        return result;
    }

    // Center-align text
    static List<String> centerAlignText(String[] words, int width) {
        List<String> result = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        for (String word : words) {
            if (line.length() + word.length() + 1 > width) {
                result.add(centerLine(line.toString().trim(), width));
                line = new StringBuilder();
            }
            line.append(word).append(" ");
        }
        if (line.length() > 0) result.add(centerLine(line.toString().trim(), width));
        return result;
    }

    static String centerLine(String text, int width) {
        int padding = (width - text.length()) / 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < padding; i++) sb.append(" ");
        sb.append(text);
        while (sb.length() < width) sb.append(" ");
        return sb.toString();
    }
}
