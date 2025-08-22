import java.util.*;
public class PasswordAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter passwords (comma separated):");
        String[] passwords = sc.nextLine().split(",");
        System.out.printf("%-15s %-8s %-10s %-10s %-10s %-10s %-10s%n",  "Password", "Length", "Upper", "Lower", "Digits", "Special", "Strength");
        for (String pwd : passwords) {
            pwd = pwd.trim();
            analyzePassword(pwd);
        }
        System.out.println("\nGenerate strong password:");
        int len = sc.nextInt();
        System.out.println("Generated: " + generatePassword(len));
    }
    static void analyzePassword(String pwd) {
        int upper = 0, lower = 0, digits = 0, special = 0;
        for (char c : pwd.toCharArray()) {
            if (c >= 65 && c <= 90) upper++;
            else if (c >= 97 && c <= 122) lower++;
            else if (c >= 48 && c <= 57) digits++;
            else special++;
        }
        int score = (pwd.length() - 8) * 2;
        if (upper > 0) score += 10;
        if (lower > 0) score += 10;
        if (digits > 0) score += 10;
        if (special > 0) score += 10;
        if (pwd.contains("123") || pwd.contains("abc") || pwd.contains("qwerty")) score -= 10;
        String strength = (score < 20) ? "Weak" : (score < 50 ? "Medium" : "Strong");
        System.out.printf("%-15s %-8d %-10d %-10d %-10d %-10d %-10s%n", pwd, pwd.length(), upper, lower, digits, special, strength);
    }
    static String generatePassword(int len) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String special = "!@#$%^&*";
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append(upper.charAt(r.nextInt(upper.length())));
        sb.append(lower.charAt(r.nextInt(lower.length())));
        sb.append(digits.charAt(r.nextInt(digits.length())));
        sb.append(special.charAt(r.nextInt(special.length())));
        String all = upper + lower + digits + special;
        for (int i = 4; i < len; i++) sb.append(all.charAt(r.nextInt(all.length())));
        return sb.toString();
    }
}
