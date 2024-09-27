import java.math.BigDecimal;
import java.util.Comparator;

public class sortCsv {
    private BigDecimal income;
    private BigDecimal expenses;
    private BigDecimal interest;
    private BigDecimal debtLoan;
    private String typeOfLoan;

    public sortCsv(BigDecimal income, BigDecimal expenses,BigDecimal interest, BigDecimal debtLoan, String typeOfLoan){
        this.income = income;
        this.expenses = expenses;
        this.interest = interest;
        this.debtLoan = debtLoan;
        this.typeOfLoan = typeOfLoan;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public BigDecimal getExpenses() {
        return expenses;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public BigDecimal getDebtLoan() {
        return debtLoan;
    }

    public String getTypeOfLoan() {
        return typeOfLoan;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s", income, expenses, debtLoan, interest, typeOfLoan);
    }


}
class csvIncomeComparator implements Comparator<sortCsv>{
    @Override
    public int compare(sortCsv b1, sortCsv b2){
        return b1.getIncome().compareTo(b2.getIncome());
    }
}

class csvExpensesComparator implements  Comparator<sortCsv>{
    @Override
    public int compare(sortCsv b1, sortCsv b2){
        return b1.getExpenses().compareTo(b2.getExpenses());
    }
}

class csvInterestComparator implements Comparator<sortCsv>{
    @Override
    public int compare(sortCsv b1, sortCsv b2){
        return b1.getInterest().compareTo(b2.getInterest());
    }
}

class csvDebtLoanComparator implements Comparator<sortCsv>{
    @Override
    public int compare(sortCsv b1, sortCsv b2){
        return b1.getDebtLoan().compareTo(b2.getDebtLoan());
    }
}
