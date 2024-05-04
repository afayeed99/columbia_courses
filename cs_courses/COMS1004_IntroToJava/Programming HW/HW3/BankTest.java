/*
 * This is the BankAccount test class
 * to be used in Problem 2.
 * Use BankAccount object, deposits $10,000,
 * withdraws $600, and again withdraw $200.
 * 
 * name: Abdul Fayeed Abdul Kadir
 * UNI: aa5042
 * Date: Feb 9th, 2024 (Friday)
 */

public class BankTest{

  public static void main(String[] args){

    BankAccount myAccount;
    myAccount = new BankAccount("Abdul Fayeed",1234567);
    // provide my name and my bank account num
    
    myAccount.deposit(10000);
    myAccount.withdraw(600);
    myAccount.withdraw(200);

    double currentBalance = myAccount.getBalance();
    System.out.println("Remaining balance is $" + currentBalance);
  }

}
