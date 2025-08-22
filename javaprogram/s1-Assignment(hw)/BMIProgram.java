import java.util.Scanner;

public class BMIProgram {

    // Method to calculate BMI and status
    public static String[] calculateBMI(double weight, double heightCm) {
        double heightM = heightCm / 100; // Convert cm to meters
        double bmi = weight / (heightM * heightM);

        String status;
        if (bmi < 18.5) status = "Underweight";
        else if (bmi < 24.9) status = "Normal";
        else if (bmi < 29.9) status = "Overweight";
        else status = "Obese";

        return new String[]{String.format("%.2f", bmi), status};
    }

    // Method to compute BMI for all persons
    public static String[][] computeAll(double[][] hwArray) {
        String[][] result = new String[hwArray.length][4];
        for (int i = 0; i < hwArray.length; i++) {
            String[] bmiStatus = calculateBMI(hwArray[i][0], hwArray[i][1]);
            result[i][0] = String.valueOf(hwArray[i][0]); // Weight
            result[i][1] = String.valueOf(hwArray[i][1]); // Height
            result[i][2] = bmiStatus[0]; // BMI
            result[i][3] = bmiStatus[1]; // Status
        }
        return result;
    }

    // Method to display in tabular format
    public static void display(String[][] data) {
        System.out.println("\nWeight(kg)\tHeight(cm)\tBMI\t\tStatus");
        for (String[] row : data) {
            System.out.printf("%s\t\t%s\t\t%s\t\t%s\n", row[0], row[1], row[2], row[3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] hwArray = new double[10][2];

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            hwArray[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            hwArray[i][1] = sc.nextDouble();
        }

        String[][] results = computeAll(hwArray);
        display(results);
        sc.close();
    }
}
