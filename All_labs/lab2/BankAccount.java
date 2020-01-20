
public class BankAccount{
  String name;
  private String password;
  double balance;

  public void withdraw(String enteredPassword, double amount){
    if(password.equals(enteredPassword) && balance >= amount){
      balance = balance - amount;
    }
  }

  public void deposit(String enteredPassword, double amount){
    if(password.equals(enteredPassword)){
      balance = balance + amount;
    }
  }

  public double getBalance(String enteredPassword){
    if(password.equals(enteredPassword)){
      return balance;
    }
    else{
      return -1;
    }
  }

  public boolean setPassword(String oldPassword, String newPassword){
    if(password.equals(oldPassword)){
      password = newPassword;
      return true;
    }
    else{
      return false;
    }
  }

  public BankAccount(String initName, String initPass, double initBalance){
    this.name = initName;
    this.password = initPass;
    this.balance = initBalance;
  }

  public static void main(String args[]){

    BankAccount myAccount = new BankAccount("Java","CSCI1933 rules!", 100.50);
    myAccount.deposit("CSCI1933 rules!",100.50);
    System.out.println("My account's balance is: " + myAccount.balance);
  }
}
