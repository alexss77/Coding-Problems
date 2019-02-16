import java.util.Scanner;
public class cs210Queue
{
	public static void main(String args[]) throws Exception
	{
		Scanner scan=new Scanner(System.in);
		Queue theQueue=new Queue(100);
		while(scan.hasNextLine())
		{
			String temp=scan.nextLine();
			if(temp.matches("REMOVE"))
			{
				theQueue.remove();
			}
			else
			{
				theQueue.insert(temp.substring(7));
			}
		}
		int size=theQueue.size();
		if(size%2==1)
		{
			int medium=size/2;
			for(int i=0;i<medium;i++)
			{
				theQueue.remove();
			}
			System.out.println(theQueue.remove());
		}
		else if(size==0)
		{
			System.out.println("empty");
		}
		if(size%2==0)
		{
			int medium=size/2;
			for(int i=0;i<medium-1;i++)
			{
				theQueue.remove();
			}
			System.out.println(theQueue.remove());
		}
	}

	class Queue
	{
		private int maxSize;
		private String [] queArray;
		private int front;
		private int rear;
		private int nItems;

	public Queue(int s)
	{
		maxSize=s;
		queArray=new String[maxSize];
		front=0;
		rear=-1;
		nItems=0;
	}
	public boolean insert(String item)
	{
		if(isFull())
		{
			return false;
		}
		if(rear==maxSize-1)
		{
			rear=-1;
		}
		rear++;
		queArray[rear]=item;
		nItems++;
		return true;
	}
	public String remove()
	{
		if(isEmpty())
		{
			return "";
		}
		String temp = queArray[front];// get value and incr front
	    front++;
	    if(front == maxSize)
	    {
	    	 front = 0;
	    }
	     // deal with wraparound

	    nItems--; // one less item
	    return temp;
	}
	public boolean isEmpty()
	{
	 return (nItems==0);
	}
	public boolean isFull()
	{
	 return (nItems==maxSize);
	}
	public int size()
	{
	 return nItems;
	}
	}

}