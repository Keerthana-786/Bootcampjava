import java.util.*;

public class FileOrganizer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter file names (comma separated):");
        String[] files = sc.nextLine().split(",");

        for (String file : files) {
            file = file.trim();
            int dot = file.lastIndexOf('.');
            String name = file.substring(0, dot);
            String ext = file.substring(dot + 1);
            String category = getCategory(ext);
            System.out.printf("%-20s %-10s%n", file, category);
        }
    }

    static String getCategory(String ext) {
        if (ext.equalsIgnoreCase("txt") || ext.equalsIgnoreCase("doc")) return "Document";
        if (ext.equalsIgnoreCase("jpg") || ext.equalsIgnoreCase("png")) return "Image";
        if (ext.equalsIgnoreCase("mp3") || ext.equalsIgnoreCase("wav")) return "Audio";
        return "Unknown";
    }
}
