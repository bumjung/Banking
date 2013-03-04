import java.io.*;

public class Account
{
	public double balance;
	private int accNo;
	public static int netTotal;
	public Account(int n)
	{
		accNo = n;
	}

	public void Deposit(int n)
	{
		//System.out.println(balance);
		//System.out.println(n);
		balance += n;
		netTotal += balance;
	}
	
	public void Withdraw(int n)
	{
		if(balance >=n)
		{
			balance -= n;
			netTotal -= balance;
		}
		
		else
		{
			System.out.println("Impossible. Balance is empty");
		}
	}
	
	public int getAccNo()
	{
		return accNo;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public static int bankBalance()
	{
		return netTotal;
	}
	
		
	/*public int input(String s) throws IOException
	{
		DataInputStream in = new DataInputStream(System.in);
		
		System.out.println(s);
		int temp = Integer.parseInt(in.readLine());

		return temp;
	}*/
}