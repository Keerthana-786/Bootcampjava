import java.util.*;

public class FindReplaceManual {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter main text:");
        String text = sc.nextLine();
        System.out.println("Enter substring to find:");
        String find = sc.nextLine();
        System.out.println("Enter substring to replace:");
        String replace = sc.nextLine();

        String manualResult = manualReplace(text, find, replace);
        String builtInResult = text.replace(find, replace);

        System.out.println("Manual Replace: " + manualResult);
        System.out.println("Built-in Replace: " + builtInResult);
        System.out.println("Match? " + manualResult.equals(builtInResult));
    }

    static String manualReplace(String text, String find, String replace) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            if (i <= text.length() - find.length() && text.substring(i, i + find.length()).equals(find)) {
                result.append(replace);
                i += find.length();
            } else {
                result.append(text.charAt(i));
                i++;
            }
        }
        return result.toString();
    }
}
