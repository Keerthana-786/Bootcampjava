import java.util.Scanner;

public class StringMethods {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for their full name (first and last name)
        System.out.print("Enter your full name (first and last): ");
        String fullName = scanner.nextLine();

        // Ask user for their favorite programming language
        System.out.print("Enter your favorite programming language: ");
        String favLang = scanner.nextLine();

        // Ask user for a sentence about their programming experience
        System.out.print("Write a sentence about your programming experience: ");
        String experience = scanner.nextLine();

        // 1. Extract first and last name separately
        String[] nameParts = fullName.trim().split(" ");
        String firstName = nameParts[0];
        String lastName = nameParts.length > 1 ? nameParts[1] : "";

        // 2. Count total characters in the sentence (excluding spaces)
        String sentenceNoSpaces = experience.replace(" ", "");
        int charCount = sentenceNoSpaces.length();

        // 3. Convert programming language to uppercase
        String favLangUpper = favLang.toUpperCase();

        // 4. Display a formatted summary
        System.out.println("\n--- Summary ---");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Favorite Language: " + favLangUpper);
        System.out.println("Characters in your sentence (excluding spaces): " + charCount);
        System.out.println("Your full sentence: \"" + experience + "\"");

        scanner.close();
    }
}
