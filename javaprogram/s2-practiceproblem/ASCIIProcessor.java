import java.util.*;
public class ASCIIProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Ask user to enter a string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        System.out.println("\nCharacter Analysis:");
        for (char ch : input.toCharArray()) {
            int ascii = (int) ch;
            System.out.println("Character: " + ch + " | ASCII: " + ascii);
            System.out.println("Type: " + classifyCharacter(ch));

            if (Character.isLetter(ch)) {
                char toggled = toggleCase(ch);
                System.out.println("Toggled Case: " + toggled + " | ASCII: " + (int) toggled);
                System.out.println("Difference between cases: " + Math.abs('a' - 'A'));
            }
            System.out.println("----------------------------------");
        }// Display ASCII table for printable characters
        System.out.println("\nASCII Table (32-126):");
        displayASCIITable(32, 126);// Convert string to ASCII array and back
        int[] asciiArray = stringToASCII(input);
        System.out.println("\nASCII Array: " + Arrays.toString(asciiArray));
        System.out.println("Back to String: " + asciiToString(asciiArray));
        // Caesar Cipher
        System.out.print("\nEnter shift for Caesar Cipher: ");
        int shift = scanner.nextInt();
        String cipherText = caesarCipher(input, shift);
        System.out.println("Encrypted Text (Caesar Cipher): " + cipherText);
        scanner.close();
    }// Classify character type
    public static String classifyCharacter(char ch) {
        if (Character.isUpperCase(ch)) return "Uppercase Letter";
        else if (Character.isLowerCase(ch)) return "Lowercase Letter";
        else if (Character.isDigit(ch)) return "Digit";
        else return "Special Character";
    }
    // Toggle case using ASCII
    public static char toggleCase(char ch) {
        if (Character.isUpperCase(ch)) {
            return (char) (ch + 32); // Upper -> Lower
        } else if (Character.isLowerCase(ch)) {
            return (char) (ch - 32); // Lower -> Upper
        }
        return ch;
    }

    // Caesar Cipher implementation
    public static String caesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                char newChar = (char) ((ch - base + shift) % 26 + base);
                result.append(newChar);
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    // Display ASCII table for a given range
    public static void displayASCIITable(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println(i + " -> " + (char) i);
        }
    }

    // Convert string to ASCII array
    public static int[] stringToASCII(String text) {
        int[] asciiValues = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            asciiValues[i] = (int) text.charAt(i);
        }
        return asciiValues;
    }

    // Convert ASCII array back to string
    public static String asciiToString(int[] asciiValues) {
        StringBuilder sb = new StringBuilder();
        for (int val : asciiValues) {
            sb.append((char) val);
        }
        return sb.toString();
    }
}
