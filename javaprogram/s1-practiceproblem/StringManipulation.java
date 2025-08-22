public class StringManipulation {
    public static void main(String[] args) {
        // 1. Create the same string "Java Programming" using different methods
        String str1 = "Java Programming"; // String literal
        String str2 = new String("Java Programming"); // Using new keyword
        char[] charArray = {'J', 'a', 'v', 'a', ' ', 'P', 'r', 'o', 'g', 'r', 'a', 'm', 'm', 'i', 'n', 'g'};
        String str3 = new String(charArray); // Using character array

        // Display the strings
        System.out.println("String 1: " + str1);
        System.out.println("String 2: " + str2);
        System.out.println("String 3: " + str3);

        // Compare strings using '==' and .equals()
        System.out.println("\n--- Comparisons ---");
        System.out.println("str1 == str2: " + (str1 == str2)); // false: different memory locations
        System.out.println("str1.equals(str2): " + str1.equals(str2)); // true: same content
        System.out.println("str1 == str3: " + (str1 == str3)); // false
        System.out.println("str1.equals(str3): " + str1.equals(str3)); // true

        // Explanation
        System.out.println("\nExplanation:");
        System.out.println("The '==' operator compares memory references (object addresses).");
        System.out.println("The .equals() method compares the actual content of the strings.");

        // Escape sequences example
        String quote = "Programming Quote:\n\"Code is poetry\" - Unknown\nPath: C:\\Java\\Projects";
        System.out.println("\n" + quote);
    }
}
