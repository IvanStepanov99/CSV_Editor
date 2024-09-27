public class Main{
    public static void main(String[] args){
        String filePath = "CSV.txt";

        CsvReader reader = new CsvReader();
        CsvWriter writer = new CsvWriter();

        CalculationCsv calculation = new CalculationCsv();

        reader.readCsv(filePath);
        writer.writeToCsv(filePath);


        System.out.println(calculation.averageInterestRate(filePath)+"%");

    }
}