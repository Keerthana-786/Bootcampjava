import java.util.Scanner;

public class FrequencyWithUnique {

    public static char[] findUniqueChars(String text) {
        char[] result = new char[text.length()];
        int index = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == ch) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                result[index++] = ch;
            }
        }
        char[] unique = new char[index];
        for (int i = 0; i < index; i++) {
            unique[i] = result[i];
        }
        return unique;
    }

    public static String[][] frequencyUsingUnique(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        char[] uniqueChars = findUniqueChars(text);
        String[][] result = new String[uniqueChars.length][2];
        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = String.valueOf(uniqueChars[i]);
            result[i][1] = String.valueOf(freq[uniqueChars[i]]);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String[][] frequency = frequencyUsingUnique(text);
        System.out.println("Character | Frequency");
        for (String[] row : frequency) {
            System.out.println(row[0] + " \t\t " + row[1]);
        }
        sc.close();
    }
}
