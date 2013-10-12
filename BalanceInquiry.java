
public class BalanceInquiry extends Transaction {

	//no-argument constructor
	public BalanceInquiry(int accountNumber, Screen screen, BankDatabase bankDatabase){
		super(accountNumber, screen, bankDatabase);
	}
	
	//operations
	public void execute(){
		int accountNumber = super.getAccountNumber();
		double availableBalance = super.getBankDatabase().getAvailabeBalance(accountNumber);
		double totalBalance = super.getBankDatabase().getTotalBalance(accountNumber);
		super.getScreen().displayBalanceMenu(availableBalance, totalBalance);
	}
}
