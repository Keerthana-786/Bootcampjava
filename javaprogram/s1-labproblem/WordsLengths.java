import java.util.Scanner;
public class WordsLengths {
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        String[] words = customSplit(text);
        String[][] wordLengths = wordLengthArray(words);

        System.out.println("\nWord\tLength");
        System.out.println("----------------");
        for (String[] wl : wordLengths) {
            System.out.println(wl[0] + "\t" + Integer.parseInt(wl[1]));
        }

        sc.close();
    }
}
