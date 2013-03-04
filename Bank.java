import java.io.*;

public class Bank
{
	static Account [] a = new Account[100];
	static int size = 0;
		
		
	public static void option()
	{
		System.out.println("");
		System.out.println("1 - Open new account");
		System.out.println("2 - Withdraw");
		System.out.println("3 - Deposit");
		System.out.println("4 - Get balance");
		System.out.println("5 - Get bank balance");
		System.out.println("6 - Add interest");
		System.out.println("7 - Set new fee");
		System.out.println("8 - Set new interest");
		System.out.println("9 - Exit");
		System.out.println("");
	}
	
	public static int input(String s) throws IOException
	{
		DataInputStream in = new DataInputStream(System.in);
		
		System.out.println(s);
		int temp = Integer.parseInt(in.readLine());

		return temp;
	}
	
	public static int valid(int n)
	{
		for (int i = 0; i < a.length;i ++)
		{
			if(a[i].getAccNo() == n)
			{
				return i;
			}
		}
		
		return -1;
	}
	
	public static void openAcc(int choice, int tempA) throws IOException
	{
		if (valid(tempA) < 0)	
		{
			
			System.out.println("Opened a new account:");
			if(choice == 0)
			{
				a[size] = new Chequing(tempA);
			}
			else if(choice == 1)
			{
				a[size] = new Saving(tempA);
			}
			System.out.println("new account number is: " + tempA);
		}
		else
		{
			System.out.println("Invalid");
		}
		
		size++;

	}
	
	public static void accWithdraw(DataInputStream in, int tempA) throws IOException
	{
		int i = valid(tempA);
		
		if(i >= 0)
		{
			System.out.println("Input how much to withdraw:");
			
			if(a[i] instanceof Chequing)
			{
			
				((Chequing)a[i]).Withdraw(Integer.parseInt(in.readLine()));
			}
			else
			{
				a[i].Withdraw(Integer.parseInt(in.readLine()));
			}
		}
		else
		{
			System.out.println("Invalid");
		}
	
	}	
		
	public static void accDeposit(DataInputStream in, int tempA) throws IOException
	{
		int i = valid(tempA);
		
		if(i < 0)
		{
			System.out.println("Invalid");
			return;
		}
		
		System.out.println("Input how much to deposit:");
		if(a[i] instanceof Chequing)
		{
			((Chequing)a[i]).Deposit(Integer.parseInt(in.readLine()));
		}
		
		else
		{
			a[i].Deposit(Integer.parseInt(in.readLine()));
		}
		
		
					
	}
	
	public static void showBalance(int tempA) throws IOException
	{
					
		int i = valid(tempA);
		
		if(i >= 0)
		{
			System.out.println("Your balance is: " + a[i].getBalance());
		}
		else
		{
			System.out.println("Invalid");
		}
			
	}
	
	public static void totalBalance()
	{
		System.out.println("The total bank balance is " + Account.bankBalance());
	}
	
	public static void interest()
	{
		for (int i = 0; i < size; i ++)
		{
			if(a[i] instanceof Saving)
			{
				((Saving)a[i]).addInterest();
			
			}
		}
		
		System.out.println("Interest added");
	}
	
	public static void setFee (int tempA) throws IOException
	{
		int i = valid(tempA);
		
		if(i >= 0 && a[i] instanceof Chequing)
		{
			
			
			((Chequing) a[i]).setFee(tempA);
		}
	}
	
	public static void setInterest (int tempA) throws IOException
	{
		Saving.setInterest(tempA);
		
	}
	
	public static void main (String args[]) throws IOException
	{
		DataInputStream in = new DataInputStream(System.in);
		
		
		for(int i = 0; i < a.length; i ++)
		{
			a[i] = new Account (-1);
		}
		
		option();
		
		int choice = Integer.parseInt(in.readLine());
		int tempA;
		
		while(choice != 9)
		{
			switch(choice)
			{
				case 1: 
						int accChoice = input("0 - chequing acc, 1 - saving acc");
						tempA = input("Input a new account number:");
						openAcc(accChoice, tempA);
						break;
				
				case 2: 
						tempA = input("Input your account number to withdraw:");
						accWithdraw(in, tempA);
				break;
				
				case 3: 
						tempA = input("Input your account number to deposit:");
						accDeposit(in, tempA);
				break; 
				
				case 4: 
						tempA = input("Input your account number to show the balance:");
						showBalance(tempA);
				break;
				
				case 5: 
						totalBalance();
				break;
				
				case 6:
						interest();
				break;
				
				case 7: 
						tempA = input("Input the new fee");
						setFee(tempA);
				break;
				
				case 8: 
						tempA = input("Input the new interest %");
						setInterest(tempA);
						break;
			}
			
			option();
			
			choice = Integer.parseInt(in.readLine());	
		}
	}
}