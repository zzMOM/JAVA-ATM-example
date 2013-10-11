
public class Account {
	//attributes
	private int userAccountNumber;
	private double availableBalance;
	private double totalBalance;
	
	//no-argument constructor
	public Account(){
		
	}
	
	//activities
	public boolean validatePIN(int userAccountNumber, int pin){
		return false;
	}
	
	public boolean authenticateUser(int userAccountNumber){
		return false;
	}
	
	public double getAvailableBalance(int userAccountNumber){
		return 0;
	}
	
	public double getTotalAvailableBalance(int userAccountNumber){
		return 0;
	}
	
	public void credit(int userAccountNumber, double amount){
		
	}
	
	public void debit(int userAccountNumber, double amount){
		
	}
}
