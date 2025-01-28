import java.util.*;
class BankAccount implements Bank{
    Scanner scan = new Scanner(System.in);
    private int AccountNumber;
    private String HolderName;
    private double balance;
    public BankAccount(String HolderName,int AccountNumber,double FirstDeposit ){
        this.AccountNumber = AccountNumber;
        this.HolderName = HolderName;
        this.balance = FirstDeposit;
    }
    public void setHolderName(String name){
        this.HolderName = name;
    }
    public String getHolderName(){
        return HolderName;
    }
    public int getAccountNumber(){
        return AccountNumber;
    }
    public void checkBalance(){
        System.out.println("Balance : " + balance);
        acknowledge();
    }
    public void credit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Amount credited : " + amount);
            acknowledge();
        }
        else{
            System.out.println("Insufficient Balance");
        }
        
    }
    public void debit(double amount){
        if(balance > 0 && balance >= amount){
            balance -= amount;
            System.out.println("Amount debited : " + amount);
            System.out.println("Do you want to know Balance ? true/false");
            if(scan.nextBoolean()){
                checkBalance();
            }
            else
                acknowledge();
        }
        else{
            System.out.println("Amount didn't debited . Insufficient balance");
        }
        
    }
    public void acknowledge(){
        System.out.println("Thanks for coming! ");
    }
}
interface Bank{
    void checkBalance();
    void credit(double amount);
    void debit(double amount);
}