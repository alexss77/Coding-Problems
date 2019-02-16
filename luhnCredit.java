import java.util.Scanner;
public class luhnCredit
{
	public static void main(String args[])
	{
		Scanner scan=new Scanner (System.in);
		String number=scan.nextLine();
		int [] ar=new int [16];
		int single=0;
		int first=0;
		int second=0;
		int result=0;
		int validity=0;
		for(int i=0;i<number.length();i++)
		{
			char c=number.charAt(i);
			single=Character.getNumericValue(c);
			ar[i]=single;
		}

		for(int i=0;i<ar.length;i+=2)
		{
			ar[i]=ar[i]*2;
			if(ar[i]>=10)
			{
				first=ar[i]/10;
				second=ar[i]%10;
				result=result+(first+second);

			}
			if(ar[i]<10)
			{
				result=result+ar[i];
			}
//			4388576018410707
		}
		for(int i=1;i<ar.length;i+=2)
		{
			result=result+ar[i];
		}
		if(result%10==0)
		{
			System.out.println("card is valid");
		}
		else
		{
			System.out.println("card is invalid");
		}

	}

}