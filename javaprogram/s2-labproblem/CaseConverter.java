import java.util.*;

public class CaseConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = sc.nextLine();

        String upper = toUpperCaseManual(text);
        String lower = toLowerCaseManual(text);
        String title = toTitleCaseManual(text);

        System.out.println("Original: " + text);
        System.out.println("Uppercase: " + upper);
        System.out.println("Lowercase: " + lower);
        System.out.println("Title Case: " + title);
    }

    static String toUpperCaseManual(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c >= 'a' && c <= 'z') sb.append((char)(c - 32));
            else sb.append(c);
        }
        return sb.toString();
    }

    static String toLowerCaseManual(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') sb.append((char)(c + 32));
            else sb.append(c);
        }
        return sb.toString();
    }

    static String toTitleCaseManual(String str) {
        String lower = toLowerCaseManual(str);
        StringBuilder sb = new StringBuilder();
        boolean newWord = true;
        for (char c : lower.toCharArray()) {
            if (Character.isLetter(c) && newWord) {
                sb.append((char)(c - 32));
                newWord = false;
            } else {
                sb.append(c);
            }
            if (c == ' ') newWord = true;
        }
        return sb.toString();
    }
}
