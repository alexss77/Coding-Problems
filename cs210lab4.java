import java.util.*;
public class cs210lab4
{
	public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		int num=scan.nextInt();
		int ar[]=new int [1000];
		ArrayList<Integer> primelist=new ArrayList<Integer>();
		for(int i=0;i<ar.length;i++)
		{
			ar[i]=i;

		}
		for(int i=0;i<ar.length;i++)
		{
			boolean itsPrime=true;
			for(int j=2;j<i;j++)
			{
				if(i%j==0)
				{
					itsPrime=false;
				}


			}
				if(itsPrime)
				{
					primelist.add(i);

				}


		}
		int prime []=new int[primelist.size()];
		for(int i=0;i<primelist.size();i++)
		{
			prime[i]=primelist.get(i);
		}
		int first=0;
		int second=0;
		int result=0;
		for(int i=0;i<prime.length;i++)
		{
			if(num==prime[i])
			{
				first=first+prime[i];
				second=second+prime[i+1];
				result=second-first;
			}
			if(prime[i]>num)
			{
				first=prime[i-1];
				second=prime[i];
				result=second-first;
					break;
			}
		}
			System.out.println(result);




	}
}