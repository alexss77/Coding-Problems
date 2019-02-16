import java.util.Scanner;
public class birthRecursion
{
	public static void main(String args [])
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter years:");
		int years=scan.nextInt();
		System.out.println("Enter interest:");
		double interest=scan.nextDouble();
		System.out.println("Enter balance:");
		double balance=scan.nextDouble();
		System.out.println(String.format("%.2f",compound(years,interest,balance)));
	}
	public static double compound(int years,double interest,double balance)
	{
		if(years==0)
		{
			return balance;
		}
		double factor=(interest/100)+1;
		double three=balance;
		double two=interest;
		int one=years-1;
		return(factor*compound(one,two,three));
	}

}