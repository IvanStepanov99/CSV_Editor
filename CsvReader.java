import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

public class CsvReader{

    public static void readCsv(String path){
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;

            while((line = br.readLine()) != null){

                String[] values = line.split(",");
            try {
                BigDecimal income = new BigDecimal(values[0]);
                BigDecimal expenses = new BigDecimal(values[1]);
                BigDecimal debtLoans = new BigDecimal(values[2]);
                BigDecimal interest = new BigDecimal(values[3]);

                String typeOfLoans = values[4];
            } catch(NumberFormatException e){
                System.err.println("Invalid number format in line " + line);
                e.printStackTrace();
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }

}