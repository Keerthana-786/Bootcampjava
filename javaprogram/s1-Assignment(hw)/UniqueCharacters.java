import java.util.Scanner;

public class UniqueCharacters {

    // Method to find length without using length()
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }

    // Method to find unique characters
    public static char[] findUniqueChars(String text) {
        int len = findLength(text);
        char[] result = new char[len];
        int index = 0;

        for (int i = 0; i < len; i++) {
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

        // Create trimmed array
        char[] unique = new char[index];
        for (int i = 0; i < index; i++) {
            unique[i] = result[i];
        }
        return unique;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        char[] uniqueChars = findUniqueChars(text);
        System.out.print("Unique Characters: ");
        for (char c : uniqueChars) {
            System.out.print(c + " ");
        }
        sc.close();
    }
}
