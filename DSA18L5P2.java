import java.util.Scanner;

public class DSA18L5P2
{   
    Node front;
    Node rear;

    static class Node
    {
        int data;
        Node next = null;
        Node prev = null;

        public Node(int d)
        {
            data = d;
        }
    }
    
    public static DSA18L5P2 insert(DSA18L5P2 list, int x)
    {
        Node add = new Node(x);
        if(list.front==null)
        {    
            list.front = list.rear = add;
            list.front.next = null;
            list.front.prev = null;
        }
        else
        {
            list.rear.next = add;
            list.rear.next.prev = list.rear;
            list.rear = list.rear.next;
        }
    	return list;
    }

    public static void zZ(DSA18L5P2 list,int n)
    {
        int k=0;
        int seq = 1;
        while(k!=n)
        {
            if(seq==1)
            {
                System.out.println(list.front.data + " ");
                list.front = list.front.next;
                seq*=-1;
                k++;
            }
            else
            {
                System.out.println(list.rear.data + " ");
                list.rear = list.rear.prev;
                seq*=-1;
                k++;
            }
        }
    }

    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        DSA18L5P2 list = new DSA18L5P2();
        int i,n = cin.nextInt();
        int a[] = new int[n];
        for(i=0;i<n;i++)
        {
            a[i] = cin.nextInt();
            list = insert(list,a[i]);
        }
        zZ(list,n);
    }
}