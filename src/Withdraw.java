import java.util.Date;

public class Withdraw {
    //Private Access Modifier
    private double amount;
    private Date date;
    private String account;

    //Withdraw Class Parameterized Constructor
    Withdraw(double amount, Date date, String account){
        this.amount = amount; //Modifies the value of amount
        this.date = date; //Modifies the value of date
        this.account = account; //Modifies the value of account
    }

    //To String Method to format the Withdrawal Amount from Account.
    public String toString(){
        //your code here
        return  ("Withdrawal of: $" + amount + " Date: " + date + " from account: " + account);
    }
}

