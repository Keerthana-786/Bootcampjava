public class StringArrays {

    // Method to find the longest name
    public static String findLongestName(String[] names) {
        String longest = names[0];
        for (String name : names) {
            if (name.length() > longest.length()) {
                longest = name;
            }
        }
        return longest;
    }

    // Method to count names starting with a given letter (case-insensitive)
    public static int countNamesStartingWith(String[] names, char letter) {
        int count = 0;
        letter = Character.toLowerCase(letter);
        for (String name : names) {
            if (Character.toLowerCase(name.charAt(0)) == letter) {
                count++;
            }
        }
        return count;
    }

    // Method to format names as "Last, First"
    public static String[] formatNames(String[] names) {
        String[] formatted = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String[] parts = names[i].split(" ");
            if (parts.length >= 2) {
                formatted[i] = parts[1] + ", " + parts[0];
            } else {
                formatted[i] = names[i]; // If no last name found
            }
        }
        return formatted;
    }

    public static void main(String[] args) {
        String[] students = {"John Smith", "Alice Johnson", "Bob Brown", "Carol Davis", "David Wilson"};

        // Test findLongestName
        System.out.println("Longest Name: " + findLongestName(students));

        // Test countNamesStartingWith
        char letter = 'A';
        System.out.println("Names starting with '" + letter + "': " + countNamesStartingWith(students, letter));

        // Test formatNames
        String[] formattedNames = formatNames(students);
        System.out.println("\nFormatted Names:");
        for (String name : formattedNames) {
            System.out.println(name);
        }
    }
}
