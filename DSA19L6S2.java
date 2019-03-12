import java.util.Scanner;

public class DSA19L6S2
{
	Node f,r;

	static class Node
	{
		int data;
		Node next = null;

		public Node(int d)
		{
			data = d;
		}
	}

	public static boolean isEmpty(DSA19L6S2 list)
	{
		if(list.f == null && list.r == null)
			return false;
		return true;
	}

	public static void insert(DSA19L6S2 list , int d)
	{
		Node add = new Node(d);

		if(list.f == null && list.r == null)
			list.f = list.r = add;
		else
		{
			list.r.next = add;
			list.r = add;
			list.r.next = null;
		}
	}

	public static int deque(DSA19L6S2 list)
	{
		int ret;
		if(list.f == null && list.r == null)
			ret = -1;
		else if(list.f == list.r)
		{
			ret = list.f.data;
			list.f = null;
			list.r = null;
		}
		else
		{
			ret = list.f.data;
			list.f = list.f.next;
		}

		return ret;
	}

	public static void delMax(DSA19L6S2 q , DSA19L6S2 ans)
	{
		Node tr = q.f;
		int max = tr.data; 
		while(tr!=null)
		{
			if(tr.data>=max)
				max = tr.data;
			if(tr.next!=null)
				tr = tr.next;
			else
				break;
		}
		
		tr = q.f;
		while(true)
		{
			if(tr.data == max)
			{	
				q.f = tr.next;
				break;
			}
			else if(tr.next.data == max)
			{	
				tr.next = tr.next.next;
				break;
			}
			tr = tr.next;
		}

		insert(ans,max);
	}

	public static void minus1(DSA19L6S2 q)
	{
		Node tr = q.f;
		while(tr!=null)
		{
			if(tr.data==0)
			{}
			else
				tr.data -= 1;
			tr = tr.next;
		}
	}

	public static DSA19L6S2 combine(DSA19L6S2 list , DSA19L6S2 q)
	{
		DSA19L6S2 comb = new DSA19L6S2();
		Node tr = list.f;
		while(tr!=null)
		{
			insert(comb,tr.data);
			tr = tr.next;
		}

		tr = q.f;
		while(tr!=null)
		{
			insert(comb,tr.data);
			tr = tr.next;
		}

		return comb;
	}

	public static void print(DSA19L6S2 list)
	{
		if(list.f == null && list.r == null)
			System.out.println("EMPTY");
		else
		{
			Node tr = list.f;
			while(tr!=null)
			{
				System.out.print(tr.data + " ");
				tr = tr.next;
			}
			System.out.println();
		}
	}

	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		DSA19L6S2 list = new DSA19L6S2() , ans = new DSA19L6S2();
		int n = cin.nextInt() , x = cin.nextInt() , elt;
		for(int i=0;i<n;i++)
		{
			elt = cin.nextInt();
			insert(list,elt);
		}

		for(int c=0;c<x;c++)
		{
			DSA19L6S2 q = new DSA19L6S2();

			int i=0;
			while(i<x && isEmpty(list))
			{
				insert(q , deque(list));
				i++;
			}	

			delMax(q, ans);

			minus1(q);

			list = combine(list,q);
		}
		print(ans);
	}
}