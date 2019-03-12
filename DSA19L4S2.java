import java.io.*;
import java.util.*;
import java.lang.*;

class AlmightyReader
{
	BufferedReader br;
	StringTokenizer tk;
	public AlmightyReader()
	{
		br=new BufferedReader(new InputStreamReader(System.in));
		tk=new StringTokenizer("");
	}
	public int nextInt() throws IOException
	{
		while(!tk.hasMoreTokens())
			tk=new StringTokenizer(br.readLine());
		return Integer.parseInt(tk.nextToken());
	}
}	
class Node
{
	int num;
	Node next;
	Node(int x)
	{
		num=x;
		next=null;
	}
}

class LinkedList
{
	Node start;
	public LinkedList()
	{
		start=new Node(-1);
	}
	public boolean isEmpty()
	{
		return !(start.next==null);
	}
	public void display()
	{
		Node ptr=start.next;
		while(ptr!=null)
		{
			System.out.print(ptr.num+" ");
			ptr=ptr.next;
		}
		System.out.println();
	}
}


class DSA19L4S2
{
	static void func(LinkedList L,int k)
	{
		int x=0;
		
		while(x!=k)
		{
			Node last = L.start.next;
			while(last.next.next!=null)
			{
				last=last.next;
			}
		
			last.next.next = L.start.next;
			L.start.next = last.next;
			last.next = null;
			
			x++;
		}
		
		L.display();
	}
	public static void main(String args[]) throws IOException
	{
		AlmightyReader rd=new AlmightyReader();
		LinkedList L=new LinkedList();
		Node curr=L.start;
		int i,N=rd.nextInt(),K=rd.nextInt();
		for(i=0;i<N;i++)
		{
			curr.next=new Node(rd.nextInt());
			curr=curr.next;
		}
		func(L,K);
	}
}