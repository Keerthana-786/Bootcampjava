import java.util.*;
public class TextCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter expression (e.g., 10 + 2 * 3):");
        String exp = sc.nextLine();
        System.out.println("Result: " + evaluate(exp));
    }
    static int evaluate(String expr) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int i = 0;
        while (i < expr.length()) {
            char c = expr.charAt(i);
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < expr.length() && Character.isDigit(expr.charAt(i))) {
                    num = num * 10 + (expr.charAt(i) - '0');
                    i++;
                }
                nums.push(num);
                continue;
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(c)) {
                    compute(nums, ops.pop());
                }
                ops.push(c);
            }
            i++;
        }
        while (!ops.isEmpty()) compute(nums, ops.pop());
        return nums.pop();
    }
    static void compute(Stack<Integer> nums, char op) {
        int b = nums.pop(), a = nums.pop();
        if (op == '+') nums.push(a + b);
        else if (op == '-') nums.push(a - b);
        else if (op == '*') nums.push(a * b);
        else if (op == '/') nums.push(a / b);
    }
    static int precedence(char op) {
        return (op == '+' || op == '-') ? 1 : 2;
    }
}
