import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

public class CalculationCsv {

    public BigDecimal sumOfIncome(String path) {
        BigDecimal totalIncome = BigDecimal.ZERO;
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                if (values.length < 5) {
                    System.err.println("Invalid CSV line, skipping: " + line);
                    continue;
                }

                try {
                    BigDecimal income = new BigDecimal(values[0]);

                    totalIncome = totalIncome.add(income);

                } catch (NumberFormatException e) {
                    System.err.println("Invalid income value in line: " + line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalIncome;
    }

    public BigDecimal sumOfExpense(String path) {

        BigDecimal totalExpense = BigDecimal.ZERO;
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                if (values.length < 5) {
                    System.err.println("Invalid CSV line, skipping: " + line);
                    continue;
                }

                try {
                    BigDecimal expense = new BigDecimal(values[1]);
                    totalExpense = totalExpense.add(expense);

                } catch (NumberFormatException e) {
                    System.out.println("Invalid value in line: " + line);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalExpense;
    }

    public BigDecimal netIncome(String path){
        BigDecimal netIncome = BigDecimal.ZERO;

        netIncome = sumOfIncome(path).subtract(sumOfExpense(path));

        if(netIncome.compareTo(BigDecimal.ZERO)< 0){
            System.err.println("The Income is negative: " + netIncome);
        }
            return netIncome;
    }

    public BigDecimal sumOfDebt(String path){
        BigDecimal totalDebt = BigDecimal.ZERO;

        String line;

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            while((line= br.readLine())!= null){
                String[] values = line.split(",");

                if(values.length<5){
                    System.err.println("Invalid CSV line, skipping: " + line);
                    continue;
                }
                try {
                    BigDecimal debtLoans = new BigDecimal(values[2]);
                    totalDebt = totalDebt.add(debtLoans);
                }catch (NumberFormatException e){
                    System.err.println("Invalid value in line: " + line);
                }
            }
        } catch (IOException e){ e.printStackTrace();}
        return totalDebt;
    }
}
