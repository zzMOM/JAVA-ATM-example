
public class Account {
	//attributes
	private int userAccountNumber;
	private int pin;
	private double availableBalance;
	private double totalBalance;
	
	//no-argument constructor
	public Account(int userAccountNumber, int pin, double availableBalance, double totalBalance){
		this.userAccountNumber = userAccountNumber;
		this.pin = pin;
		this.availableBalance = availableBalance;
		this.totalBalance = totalBalance;
		
	}
	
	//set and get account info
	public void setUserAccountNumber(int number){
		userAccountNumber = number;
	}
	
	public void setPIN(int p){
		pin = p;
	} 
	
	public void setAvailableBalance(double amount){
		availableBalance = amount;
	}
	
	public void setTotalBalance(double amount){
		totalBalance = amount;
	}
	
	public int getUserAccountNumber(){
		return userAccountNumber;
	}
	
	public int getPIN(){
		return pin;
	}
	
	public double getAvailableBalance(){
		return availableBalance;
	}
	
	public double getTotalBalance(){
		return totalBalance;
	}
	
}
