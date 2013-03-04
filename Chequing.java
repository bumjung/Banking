import java.io.*;


public class Chequing extends Account
{
	private  int fee = 10;
	
	public Chequing(int n) throws IOException
	{
		super(n);
	}
	
	public void Deposit(int n)
	{
		super.Deposit(n);
		chargingFee();
	}
	
	public void Withdraw(int n)
	{
		super.Withdraw(n);
		chargingFee();
	}
	
	public void setFee(int newFee)
	{
		fee = newFee;
	}
	
	public void chargingFee()
	{
		balance -= fee;
		netTotal -= fee;
	}
}