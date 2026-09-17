
public class TestLoanClass {
  /** Main method */
  public static void main(String[] args) {
    int number1 = 0;
    Integer number2 = 0;
    




    // Create a Scanner
    Loan loan = new Loan();

    // Display loan date, monthly payment, and total payment
    System.out.printf("The loan was created on %s\n" +
      "The monthly payment is %.2f\nThe total payment is %.2f\n",
      loan.getLoanDate().toString(), loan.getMonthlyPayment(), 
      loan.getTotalPayment());
  }
}