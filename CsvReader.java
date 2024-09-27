import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CsvReader{

    public static List<sortCsv> readCsv(String path){
        List<sortCsv> csvList = new ArrayList<>();
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


                csvList.add(new sortCsv(new BigDecimal(values[0]), new BigDecimal(values[1]), new BigDecimal(values[3]),new BigDecimal(values[2]),values[4]));

            } catch(NumberFormatException e){
                System.err.println("Invalid number format in line " + line);
                e.printStackTrace();
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    return csvList;
    }

}