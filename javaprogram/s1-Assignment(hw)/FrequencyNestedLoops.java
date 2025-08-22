import java.util.Scanner;

public class FrequencyNestedLoops {

    public static String[] findFrequency(String text) {
        char[] chars = text.toCharArray();
        int[] freq = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                freq[i] = 1;
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[i] == chars[j]) {
                        freq[i]++;
                        chars[j] = '0'; // Mark as counted
                    }
                }
            }
        }

        String[] result = new String[chars.length];
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result[index++] = chars[i] + " - " + freq[i];
            }
        }

        // Trim
        String[] finalResult = new String[index];
        for (int i = 0; i < index; i++) {
            finalResult[i] = result[i];
        }
        return finalResult;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String[] frequency = findFrequency(text);
        System.out.println("Character | Frequency");
        for (String row : frequency) {
            System.out.println(row);
        }
        sc.close();
    }
}
