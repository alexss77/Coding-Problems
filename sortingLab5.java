import java.util.Scanner;
public class sortingLab5
{
	public static void main(String args[])
	{
		sorter();
	}
	public static void sorter()
	{
		//int smaller=0;
		int temp=0;
		int ar[]={2,5,1,4,8,50};

		for(int i=0;i<ar.length;i++)
		{
			for(int j=1;j<ar.length-1;j++)
			{
				if(ar[j-1]>ar[j])
				{
					temp=ar[j-1];
					ar[j-1]=ar[j];
					ar[j]=temp;
				}
			}

		}
		for(int i=0;i<ar.length;i++)
		{
			System.out.println(ar[i]);
		}
		int halfway=0;
		int size=ar.length;
		if(size%2==0)
		{
			halfway=ar[size/2]+ar[size/2-1];
			halfway=halfway/2;
		}
		else
		{
			halfway=ar[ar.length/2];
		}
		System.out.println(halfway);

	}
}