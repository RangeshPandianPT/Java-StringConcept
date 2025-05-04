import java.util.Scanner;

public class BMICalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        double[][] whData = new double[10][2];

        
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for Person " + (i + 1) + ":");
            System.out.print("Weight (kg): ");
            whData[i][0] = sc.nextDouble();
            System.out.print("Height (cm): ");
            whData[i][1] = sc.nextDouble();
        }

        
        String[][] result = processBMI(whData);

        
        displayTable(result);
    }

    
    public static String[][] processBMI(double[][] whData) {
        String[][] result = new String[whData.length][4]; 

        for (int i = 0; i < whData.length; i++) {
            double weight = whData[i][0];
            double heightCm = whData[i][1];
            double heightM = heightCm / 100.0;

            double bmi = weight / (heightM * heightM);
            bmi = Math.round(bmi * 100.0) / 100.0;

            String status = getStatus(bmi);

            result[i][0] = String.valueOf(weight);
            result[i][1] = String.valueOf(heightCm);
            result[i][2] = String.valueOf(bmi);
            result[i][3] = status;
        }

        return result;
    }

    
    public static String getStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
    }

    
    public static void displayTable(String[][] data) {
        System.out.println("\nBMI Report:");
        System.out.println("Person\tWeight(kg)\tHeight(cm)\tBMI\t\tStatus");
        System.out.println("--------------------------------------------------------------");

        for (int i = 0; i < data.length; i++) {
            System.out.println((i + 1) + "\t" + data[i][0] + "\t\t" + data[i][1] + "\t\t" +
                    data[i][2] + "\t\t" + data[i][3]);
        }
    }
}
