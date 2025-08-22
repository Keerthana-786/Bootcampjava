public class StringPerformanceComparison {
    public static void main(String[] args) {
        System.out.println("=== PERFORMANCE COMPARISON ===");
        int iterations = 10000;
        long startTime = System.nanoTime();
        String result1 = concatenateWithString(iterations);
        long endTime = System.nanoTime();
        System.out.println("String concatenation time: " + (endTime - startTime) + " ns");
        startTime = System.nanoTime();
        String result2 = concatenateWithStringBuilder(iterations);
        endTime = System.nanoTime();
        System.out.println("StringBuilder concatenation time: " + (endTime - startTime) + " ns");
        startTime = System.nanoTime();
        String result3 = concatenateWithStringBuffer(iterations);
        endTime = System.nanoTime();
        System.out.println("StringBuffer concatenation time: " + (endTime - startTime) + " ns");
        System.out.println("\n=== DEMONSTRATE STRINGBUILDER METHODS ===");
        demonstrateStringBuilderMethods();
        System.out.println("\n=== THREAD SAFETY DEMONSTRATION ===");
        demonstrateThreadSafety();
        System.out.println("\n=== STRING COMPARISON METHODS ===");
        compareStringComparisonMethods();
        System.out.println("\n=== MEMORY EFFICIENCY DEMONSTRATION ===");
        demonstrateMemoryEfficiency();
    }
    public static String concatenateWithString(int iterations) {
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += "Java " + i + " ";
        }
        return result;
    }
    public static String concatenateWithStringBuilder(int iterations) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java ").append(i).append(" ");
        }
        return sb.toString();
    }
    public static String concatenateWithStringBuffer(int iterations) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java ").append(i).append(" ");
        }
        return sb.toString();
    }
    public static void demonstrateStringBuilderMethods() {
        StringBuilder sb = new StringBuilder("Hello World");
        sb.append("!!!");
        System.out.println("After append: " + sb);
        sb.insert(6, "Java ");
        System.out.println("After insert: " + sb);
        sb.delete(6, 11);
        System.out.println("After delete: " + sb);
        sb.deleteCharAt(5);
        System.out.println("After deleteCharAt: " + sb);
        sb.reverse();
        System.out.println("After reverse: " + sb);
        sb.reverse(); // Back to original
        sb.replace(6, 11, "Universe");
        System.out.println("After replace: " + sb);
        sb.setCharAt(0, 'h');
        System.out.println("After setCharAt: " + sb);
        System.out.println("Capacity: " + sb.capacity());
        sb.ensureCapacity(100);
        System.out.println("After ensureCapacity(100): " + sb.capacity());
        sb.trimToSize();
        System.out.println("After trimToSize: " + sb.capacity());
    }
    public static void demonstrateThreadSafety() {
        StringBuffer sbf = new StringBuffer("Start");
        StringBuilder sbd = new StringBuilder("Start");
        Runnable task1 = () -> {
            for (int i = 0; i < 1000; i++) sbf.append("X");
        };
        Runnable task2 = () -> {
            for (int i = 0; i < 1000; i++) sbd.append("X");
        };
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task1);
        Thread t3 = new Thread(task2);
        Thread t4 = new Thread(task2);
        t1.start(); t2.start(); t3.start(); t4.start();
        try {
            t1.join(); t2.join(); t3.join(); t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("StringBuffer length (thread-safe): " + sbf.length());
        System.out.println("StringBuilder length (NOT thread-safe): " + sbd.length());
    }
    public static void compareStringComparisonMethods() {
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");
        System.out.println("== operator (str1 == str2): " + (str1 == str2)); // true
        System.out.println("== operator (str1 == str3): " + (str1 == str3)); // false
        System.out.println("equals(): " + str1.equals(str3)); // true
        System.out.println("equalsIgnoreCase(): " + str1.equalsIgnoreCase("hello")); // true
        System.out.println("compareTo(): " + str1.compareTo(str3)); // 0
        System.out.println("compareToIgnoreCase(): " + str1.compareToIgnoreCase("hello")); // 0
    }
    // Demonstrate memory efficiency
    public static void demonstrateMemoryEfficiency() {
        String str = "Java";
        String str2 = "Java";
        String str3 = new String("Java");

        System.out.println("String pool behavior: str == str2 ? " + (str == str2)); // true
        System.out.println("str == str3 ? " + (str == str3)); // false

        StringBuilder sb = new StringBuilder();
        System.out.println("Initial capacity: " + sb.capacity());
        sb.append("Java Performance Test");
        System.out.println("After append: " + sb.capacity());
    }
}
