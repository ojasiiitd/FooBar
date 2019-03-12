import java.util.Scanner;

public class DSA19L5S2
{   
    Node head;
    Node last;
    Node mid;

    static class Node
    {
        int data=1;
        Node next = null;
        Node prev = null;

        public Node(int d)
        {
            data = d;
        }
    }
    
    public static DSA19L5S2 insertX(DSA19L5S2 list, int x,int size)
    {
    	Node add = new Node(x);
    	list.last.next = add;
    	add.prev = list.last;
    	add.next = null;
    	list.last = add;

    	if(size%2==1)
    		list.mid = list.mid.next;

    	return list;
    }
    
    public static DSA19L5S2 delete1(DSA19L5S2 list, int size)
    {
    	list.head = list.head.next;
    	list.head.prev = null;

  		if(size%2==1)
  			list.mid = list.mid.next;

    	return list;
    }

    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        DSA19L5S2 list = new DSA19L5S2();
        Node f = new Node(1);
        list.head = f;
        list.head.prev = null;
        list.head.next = null;
        list.last = list.head;
        list.mid = list.head;
        
        int q = cin.nextInt(),x,m,size=1;
        while(q>0)
        {
        	m = cin.nextInt();
        	if(m==1)
        	{	
        		size++;
        		x = cin.nextInt();
        		list = insertX(list,x,size);
        	}
        	
        	else if(m==2)
        	{
        		size--;
        		list = delete1(list,size);
        	}
        	
        	else if(m==3)
        	{
        		if(size%2==0)
        			System.out.println(list.mid.data + " " + list.mid.next.data);
        		else
        			System.out.println(list.mid.data);
        	}
        	q--;
        }
    }
}