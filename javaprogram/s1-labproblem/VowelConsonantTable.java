import java.util.Scanner;
public class VowelConsonantTable {
    // a. Method to check vowel/consonant/not a letter
    public static String checkCharacterType(char ch) {
        // i. Convert uppercase to lowercase using ASCII values
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }
        // ii. Check letter type
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
    // b. Method to return 2D array with character and type
    public static String[][] findCharacterTypes(String str) {
        String[][] result = new String[str.length()][2];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = checkCharacterType(ch);
        }
        return result;
    }
    // c. Method to display 2D array in table format
    public static void displayTable(String[][] data) {
        System.out.println("Character\tType");
        System.out.println("--------------------------");
        for (String[] row : data) {
            System.out.println(row[0] + "\t\t" + row[1]);
        }
    }
    // d. Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        String[][] charTypes = findCharacterTypes(input);
        displayTable(charTypes);
        sc.close();
    }
}
