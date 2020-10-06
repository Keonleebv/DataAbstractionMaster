import java.util.Date;

public class Deposit {
    //Private Access Modifier
    private double amount;
    private Date date;
    private String account;

    //Deposit Class Parameterized Constructor
    Deposit(double amount, Date date, String account){
        this.amount = amount;  //Modifies value of amount
        this.date = date; //Modifies value of date
        this.account = account; //Modifies value of account
    }
    //To String Method to format the Deposit Amount into Account.
    public String toString(){
        //your code here
        return  ("Deposit of: $" + amount + " Date: " + date + " into account: " + account);
    }
}
