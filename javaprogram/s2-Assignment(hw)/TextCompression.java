import java.util.*;

public class TextCompression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text to compress:");
        String text = sc.nextLine();

        char[] chars = new char[text.length()];
        int[] freq = new int[text.length()];
        int size = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int idx = findIndex(chars, size, c);
            if (idx == -1) {
                chars[size] = c;
                freq[size] = 1;
                size++;
            } else {
                freq[idx]++;
            }
        }

        System.out.println("Character Frequencies:");
        for (int i = 0; i < size; i++) {
            System.out.println(chars[i] + " : " + freq[i]);
        }
        System.out.println("\n(Compression and decompression steps can be extended with mapping.)");
    }

    static int findIndex(char[] arr, int size, char c) {
        for (int i = 0; i < size; i++) if (arr[i] == c) return i;
        return -1;
    }
}
