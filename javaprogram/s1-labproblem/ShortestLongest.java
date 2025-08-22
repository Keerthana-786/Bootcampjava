import java.util.Scanner;
public class ShortestLongest{
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {}
        return count;
    }
    public static String[] customSplit(String text) {
        int length = findLength(text);
        int wordCount = 1;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') wordCount++;
        }
        String[] words = new String[wordCount];
        String current = "";
        int index = 0;
        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            if (ch == ' ') {
                words[index++] = current;
                current = "";
            } else {
                current += ch;
            }
        }
        words[index] = current;
        return words;
    }
    public static String[][] wordLengthArray(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }
    // e. Find shortest and longest word
    public static int[] findShortestLongest(String[][] wordLengths) {
        int shortestIndex = 0;
        int longestIndex = 0;
        for (int i = 1; i < wordLengths.length; i++) {
            int len = Integer.parseInt(wordLengths[i][1]);
            if (len < Integer.parseInt(wordLengths[shortestIndex][1])) {
                shortestIndex = i;
            }
            if (len > Integer.parseInt(wordLengths[longestIndex][1])) {
                longestIndex = i;
            }
        }
        return new int[]{shortestIndex, longestIndex};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        String[] words = customSplit(text);
        String[][] wordLengths = wordLengthArray(words);
        int[] indices = findShortestLongest(wordLengths);

        System.out.println("\nWord\tLength");
        System.out.println("----------------");
        for (String[] wl : wordLengths) {
            System.out.println(wl[0] + "\t" + wl[1]);
        }

        System.out.println("\nShortest Word: " + wordLengths[indices[0]][0] +
                " (Length: " + wordLengths[indices[0]][1] + ")");
        System.out.println("Longest Word: " + wordLengths[indices[1]][0] +
                " (Length: " + wordLengths[indices[1]][1] + ")");

        sc.close();
    }
}
