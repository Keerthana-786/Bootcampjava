import java.util.*;

public class StringPerformanceComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of iterations:");
        int n = sc.nextInt();

        long stringTime = testString(n);
        long builderTime = testStringBuilder(n);
        long bufferTime = testStringBuffer(n);

        System.out.println("=== Performance Comparison ===");
        System.out.printf("String Concatenation: %d ms%n", stringTime);
        System.out.printf("StringBuilder: %d ms%n", builderTime);
        System.out.printf("StringBuffer: %d ms%n", bufferTime);
    }

    static long testString(int n) {
        long start = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < n; i++) str += "a";
        return System.currentTimeMillis() - start;
    }

    static long testStringBuilder(int n) {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append("a");
        return System.currentTimeMillis() - start;
    }

    static long testStringBuffer(int n) {
        long start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) sb.append("a");
        return System.currentTimeMillis() - start;
    }
}
