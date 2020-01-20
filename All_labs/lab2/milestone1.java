public class BankAccount{
  String name;
  String password;
  double balance;

  public void withdraw(String enteredPassword, double amount){
    if(password.equals(enteredPassword) && balance >= amount){
      balance = balance - amount;
    }
  }
  public void deposit(String eneteredPassword, double amount){
    if(password.equals(enteredPassword)){
      balance = balance + amount;
    }
  }
