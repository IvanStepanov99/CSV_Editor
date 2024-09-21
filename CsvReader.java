
public class CsvReader{

    public static void readCsv(String path){
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;

            while((line = br.readLine()) != null){

                String[] values = line.split(",");

                BigDecimal income = new BigDecimal(values[0]);
                BigDecimal expenses = new BigDecimal(values[1]);
                BigDecimal debtLoans = new BigDecimal(values[2]);
                BigDecimal interest = new BigDecimal(values[3]);

                String typeOfLoans = values[4];
            }
        } catch (IOException e) {
            e.printStackTrace;
        }

    }

}