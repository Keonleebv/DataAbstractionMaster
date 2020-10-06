import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    // Private Access Modifier
    private int accountNumber;
    //ArrayList of Deposit Type
    private ArrayList<Deposit> deposits;
    //ArrayList of Withdraw Type
    private ArrayList<Withdraw> withdraws;
    // Private Access Modifier
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    //Constant Strings
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";

    private final int OVERDRAFT = -100;

    Customer() {
        //create default constructor
        //Initializes Class members to blank or zero upon the Class Object Creation
        this("", 0, 0, 0);
    }
    // Parameterized Constructor
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit) {
        //constructor code here
        //Assigns values to Class members
        this.name = name;  //Modifies Name
        this.accountNumber = accountNumber; //Modifies Account number
        this.checkBalance = checkDeposit;  //Modifies Check Balance
        this.savingBalance = savingDeposit; //Modifies Saving Balance
        //Initializes the ArrayList of Deposit Type
        deposits = new ArrayList<>();
        //Initializes the ArrayList of Withdraw Type
        withdraws = new ArrayList<>();
    }

    // Deposit method
    public double deposit(double amt, Date date, String account) {
        //your code here
        if (CHECKING.equalsIgnoreCase(account)) {
            //Deposit object
            Deposit d = new Deposit(amt, new Date(), account);
            deposits.add(d);
            checkBalance = checkBalance + amt;
            return amt;
        } else if (SAVING.equalsIgnoreCase(account)) {
            Deposit d = new Deposit(amt, new Date(), account);
            deposits.add(d);
            savingBalance = savingBalance + amt;
            return amt;
        }
        return 0;
    }

    // Withdraw method
    public double withdraw(double amt, Date date, String account) {
        //your code here
        // Checking Overdraft Limit by Calling CheckOverDraft Function
        if (checkOverdraft(amt, account)) {
            if (CHECKING.equalsIgnoreCase(account)) {
                //Withdraw object
                Withdraw d = new Withdraw(amt, new Date(), account);
                withdraws.add(d);
                checkBalance = checkBalance - amt;
                return amt;
            } else if (SAVING.equalsIgnoreCase(account)) {
                Withdraw d = new Withdraw(amt, new Date(), account);
                withdraws.add(d);
                savingBalance = savingBalance - amt;
                return amt;
            }
        }
        return 0;
    }
    //Function for Checking OverDraft Limit
    private boolean checkOverdraft(double amt, String account) {
        //your code here
        double bal = 0;
        //Calculations for Checking Overdraft Limit
        if (CHECKING.equalsIgnoreCase(account)) {
            bal = checkBalance - amt;
            return bal >= OVERDRAFT;
        } else if (SAVING.equalsIgnoreCase(account)) {
            bal = savingBalance - amt;
            return bal >= OVERDRAFT;
        }
        return false;
    }

    //Customer.deposit() method
    //do not modify
    public void displayDeposits() {
        for (Deposit d : deposits) {
            System.out.println(d);
        }
    }

    //Customer.withdraw() method
    //do not modify
    public void displayWithdraws() {
        for (Withdraw w : withdraws) {
            System.out.println(w);
        }
    }
}
