import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;

public class CsvWriter {
    public static void writeToCsv(String path,Scanner keyboard){
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, true))){

            String toContinue;

            do{
                System.out.println("Please enter income: ");
                BigDecimal income = new BigDecimal(keyboard.nextLine());

                System.out.println("Please enter expense: ");
                BigDecimal expense = new BigDecimal(keyboard.nextLine());

                System.out.println("Please enter debt/loan: ");
                BigDecimal debtLoan = new BigDecimal(keyboard.nextLine());

                System.out.println("Please enter interest ");
                BigDecimal interest = new BigDecimal(keyboard.nextLine());

                System.out.println("Please enter type of loan ");
                String typeOfLoan = keyboard.nextLine();

                pw.println(income+","+expense+","+debtLoan+","+interest+","+typeOfLoan);

                System.out.println("Would you like to continue? yes/no:");
                toContinue = keyboard.nextLine();

            }while (toContinue.equalsIgnoreCase("yes"));

            System.out.println("Data sucssesfully added to the " + path);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
