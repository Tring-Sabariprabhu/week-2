
public class Main{
    public static void main(String args[]){
        BankAccount b = new BankAccount("Sabari", 123, 1000);
        // Parameters => HolderName, AccountNumber, balance
        b.checkBalance();
        b.credit(100);
        b.debit(500);
    }
}