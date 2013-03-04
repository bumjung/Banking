import java.io.*;


public class Saving extends Account
{
	private static double percent = 0.01;
	
	public Saving(int n) throws IOException
	{
		super(n);
	}
	
	public void addInterest()
	{
		
		balance *= (1+percent);
	}
	
	
	public static void setInterest(int newPercent)
	{
		percent = newPercent * 0.01;
	}
}