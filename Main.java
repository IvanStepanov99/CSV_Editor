public class Main{
    public static void main(String[] args){
        String filePath = "CSV.txt";
        CsvReader reader = new CsvReader();
        CalculationCsv calculation = new CalculationCsv();

        reader.readCsv(filePath);

        System.out.println(calculation.sumOfDebt(filePath));

    }
}