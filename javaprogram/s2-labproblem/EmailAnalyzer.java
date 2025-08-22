import java.util.*;

public class EmailAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter emails (comma separated):");
        String[] emails = sc.nextLine().split(",");

        for (String email : emails) {
            email = email.trim();
            boolean valid = validate(email);
            if (valid) {
                String username = email.substring(0, email.indexOf('@'));
                String domain = email.substring(email.indexOf('@') + 1);
                String domainName = domain.substring(0, domain.lastIndexOf('.'));
                String extension = domain.substring(domain.lastIndexOf('.') + 1);
                System.out.printf("%s | %s | %s | %s | %s | %s%n",
                        email, username, domain, domainName, extension, "Valid");
            } else {
                System.out.printf("%s | Invalid%n", email);
            }
        }
    }

    static boolean validate(String email) {
        int at = email.indexOf('@');
        int lastAt = email.lastIndexOf('@');
        int dot = email.lastIndexOf('.');
        return at > 0 && at == lastAt && dot > at + 1 && dot < email.length() - 1;
    }
}
