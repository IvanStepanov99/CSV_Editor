import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

public class CalculationCsv {

    public BigDecimal sumOfIncome(String path) {
        BigDecimal totalIncome = BigDecimal.ZERO;
        String line;

        try (BufferedReader br =  new BufferedReader(new FileReader(path))) {

            while ((line = br.readLine()) != null){
                String [] values = line.split(",");

                if(values.length<5){
                    System.err.println("Invalid CSV line, skipping: " + line);
                    continue;
                }

                try {
                    BigDecimal income = new BigDecimal(values[0]);

                    totalIncome = totalIncome.add(income);

                } catch (NumberFormatException e){
                    System.err.println("Invalid income value in line: " + line);
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return totalIncome;
    }
}