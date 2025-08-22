import java.util.*;

public class CSVAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter CSV data (lines, comma separated):");
        String data = sc.useDelimiter("\\Z").next();

        String[] lines = data.split("\n");
        for (String line : lines) {
            String[] fields = line.split(",");
            for (String f : fields) System.out.print(f.trim() + " | ");
            System.out.println();
        }
    }
}
