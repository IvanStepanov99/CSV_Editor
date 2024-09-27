import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath = "CSV.txt";
        Scanner keyboard = new Scanner(System.in);
        boolean exit = false;
        CalculationCsv calculation = new CalculationCsv();
        CsvWriter writer = new CsvWriter();

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Total of Income");
            System.out.println("2. Total of Expenses");
            System.out.println("3. Net Income (Savings)");
            System.out.println("4. Total of Debt/Loan");
            System.out.println("5. Average Interest Rate");
            System.out.println("6. Sort the CSV file");
            System.out.println("7. Add data to the CSV file");
            System.out.println("8. Quit");
            System.out.print("Please select an option: ");
            int option = keyboard.nextInt();
            keyboard.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Total Income: $" + calculation.sumOfIncome(filePath));
                    break;
                case 2:
                    System.out.println("Total Expenses: $" + calculation.sumOfExpense(filePath));
                    break;
                case 3:
                    System.out.println("Net Income: $" + calculation.netIncome(filePath));
                    break;
                case 4:
                    System.out.println("Total of Debt/Loan: $" + calculation.sumOfDebt(filePath));
                    break;
                case 5:
                    System.out.println("Average Interest Rate $" + calculation.averageInterestRate(filePath) + "%");
                    break;
                case 6:
                    sortCvsMenu(filePath);
                    break;
                case 7:
                    writer.writeToCsv(filePath);
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again!");
            }
        }
        keyboard.close();
    }

    public static void sortCvsMenu(String path) {
        Scanner scanner = new Scanner(System.in);
        List<sortCsv> csvList = CsvReader.readCsv(path);

        boolean exit = false;
        while (!exit) {
            System.out.println("\nSorting Menu:");
            System.out.println("A - Sort by Income");
            System.out.println("B - Sort by Expenses");
            System.out.println("C - Sort by Interest");
            System.out.println("D - Sort by Debt/Loan");
            System.out.println("Q - Quit");
            System.out.print("Select an option: ");
            String sortOption = scanner.nextLine().toUpperCase();

            switch (sortOption) {
                case "A":
                    Collections.sort(csvList, new csvIncomeComparator());
                    break;
                case "B":
                    Collections.sort(csvList, new csvExpensesComparator());
                    break;
                case "C":
                    Collections.sort(csvList, new csvInterestComparator());
                    break;
                case "D":
                    Collections.sort(csvList, new csvDebtLoanComparator());
                    break;
                case "Q":
                    exit = true;
                    continue;
                default:
                    System.out.println("Invalid option. Please try again.");
                    continue;
            }

            System.out.println("Sorted Data:");
            for (sortCsv record : csvList) {
                System.out.println(record);
            }

        }
    }
}