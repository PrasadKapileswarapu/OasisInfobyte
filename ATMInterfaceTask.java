import java.util.Scanner;

class BankAccount{
	 
	private double balance;
	
	public BankAccount(double initialBalance) {
		this.balance = initialBalance;
	}
	
	public void deposit(double amount) {
		if(amount>0) {
			balance += amount;
			System.out.println("Deposited :"+amount);
		} else {
			System.out.println("Invalid Deposit Amount!");
		}
	}
	public void withdraw(double amount) {
		if(amount>0 && amount<=balance) {
			balance -= amount;
			System.out.println("Withdrawn :"+amount);
		} else {
			System.out.println("Insufficient Balance!");
		}
	}
	public void checkBalance() {
		System.out.println("Current Balance :"+balance);
	}
}
public class ATMInterfaceTask {

	public static void main(String[] args) {
       
		  Scanner sc = new Scanner(System.in);
		  BankAccount account = new BankAccount(1000);
		  
		  while(true) {
			  System.out.println("\n=======ATM Menu=======");
			  System.out.println("1.Check Balance");
			  System.out.println("2.Deposit");
			  System.out.println("3.Withdraw");
			  System.out.println("4.Exit");
			  System.out.println("Choose an option:");
			  
			  int choice = sc.nextInt();
			  sc.close();
			  switch(choice) {
			  
			  case 1: account.checkBalance();
			          break;
			  case 2: System.out.println("Enter Amount to deposit :");
			          double depositAmount = sc.nextDouble();
			          account.deposit(depositAmount);
			          break;
			  case 3: System.out.println("Enter Amount to Withdraw :");
			          double withdrawAmount = sc.nextDouble();
			          account.withdraw(withdrawAmount);
			          break;
			  case 4: System.out.println("Thank You For Using ATM!");
			          break;
			  default : System.out.println("Invalid Option!Try Again");
			  } 
		  }
    }
}
