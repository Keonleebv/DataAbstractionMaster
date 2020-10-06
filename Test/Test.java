import java.util.Date;
public class Test {


    public static void main(String[] args) {
        //Modifies this
        //Makes new Customer Object with Parameterized Constructor
        Customer c = new Customer("Keon Lee", 1234, 100, 50);
        //Calls Deposit Method
        c.deposit(400, new Date(), Customer.CHECKING);
        c.deposit(500, new Date(), Customer.SAVING);

        //Display Deposit Called
        c.displayDeposits();
        System.out.println("\t");

        //Withdraw Method Called
        c.withdraw(400, new Date(), Customer.CHECKING);
        c.withdraw(500, new Date(), Customer.SAVING);

        //Effects: add amt/date
        //Display Withdraw Called
        c.displayWithdraws();

    }
}