
/**
 * class Screen represents an ATM's screen
 * @author weiwu
 *
 */
public class Screen {
	//no attributes have been specified yet
	
	//no-argument constructor
	public Screen(){
		
	}
	
	//operations
	public void pinMessage(){
		System.out.println("Please enter your PIN!\n");
	}
	
	public void pinErrorMessage(){
		System.out.println("Wrong PIN! Please check your account!\n");
	}
	
	public void accountErrorMessage(){
		System.out.println("Wrong account number! Please check your account number!\n");
	}
	
	public void accountBalanceErrorMessage(){
		System.out.println("ERROR! Please check your account balance!\n");
	}
	
	public void insufficientCashMessage(){
		System.out.println("Sorry! We don't have enough cash in the ATM!");
		System.out.println("Please try again!\n");
	}
	
	public void takeCashMessage(){
		System.out.println("Please take your cash from the cash dispenser!\n");
	}
	
	public void insertEnvelopeMessage(){
		System.out.println("Please insert your deposit envelope into the deposit slot!\n");
	}
	
	public void displayWelcome(){
		System.out.println("Welcome!");
		System.out.println("Please enter your account number:");
		System.out.println();
	}
	
	public void displayMainMenu(){
		System.out.println("Main Menu");
		System.out.println("1-View my balance");
		System.out.println("2-Withdrawal Cash");
		System.out.println("3-Deposit funds");
		System.out.println("4-Exit");
		System.out.println("Please enter a choice:\n");
	}
	
	public void displayWithdrawalMenu(){
		System.out.println("Withdrawal Menu");
		System.out.println("1-$20		4-$100");
		System.out.println("2-$40		5-$200");
		System.out.println("3-$60		6-Cancel transaction");
		System.out.println("Choice a withdrawal amount:\n");
	}
	
	public void displayBalanceMenu(double availableBalance, double totalBalance){
		System.out.println("This is your account balance!");
		System.out.println("Account available balance is: " + availableBalance);
		System.out.println("Account total balance is: " + totalBalance);

	}
	
	public void displayDepositMenu(){
		System.out.println("Deposit Menu");
		System.out.println("Enter deposit amount: ");
		System.out.println("Type 0 to cancel transaction!\n");
	}
	
	public void afterTransactionChoice(){
		System.out.println("1- Return to main menu");
		System.out.println("2- Exit");
	}
}
