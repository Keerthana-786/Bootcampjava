import java.util.Scanner;
public class VowelConsonant {
    // a. Method to check if a character is vowel/consonant/not a letter
    public static String checkCharacterType(char ch) {
        // i. Convert uppercase to lowercase using ASCII values
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32); // converting to lowercase
        }
        // ii. Check if it's a letter
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }
    // b. Method to count vowels and consonants
    public static int[] countVowelsAndConsonants(String str) {
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < str.length(); i++) { // here built-in length is fine for loop limit
            char ch = str.charAt(i);
            String type = checkCharacterType(ch);

            if (type.equals("Vowel")) {
                vowels++;
            } else if (type.equals("Consonant")) {
                consonants++;
            }
        }
        return new int[]{vowels, consonants};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take user input
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        // Count vowels and consonants
        int[] counts = countVowelsAndConsonants(input);
        // c. Display result
        System.out.println("Vowels: " + counts[0]);
        System.out.println("Consonants: " + counts[1]);
        sc.close();
    }
}
