import java.util.Scanner;
public class StringLength {
    // Method to find string length without using length()
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count); // try accessing each index
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Exception means we've reached the end of the string
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // a. Take user input using next()
        System.out.print("Enter a string: ");
        String input = sc.next();
        // b. Call user-defined method
        int customLength = findLength(input);
        // c. Call built-in method
        int builtInLength = input.length();
        // Display results
        System.out.println("Length (Custom Method): " + customLength);
        System.out.println("Length (Built-in length()): " + builtInLength);
        sc.close();
    }
}
