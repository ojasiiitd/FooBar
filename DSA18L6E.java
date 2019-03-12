import java.io.*;

public class DSA18L6E
{   
    Node top;

    static class Node
    {
        long data;
        Node next=null;

        public Node(long d)
        {
            data = d;
        }
    }
    
    public static DSA18L6E push(DSA18L6E list, long x)
    {
        Node add = new Node(x);
        if(list.top == null)
        {    
            list.top = add;
        }
        else
        { 
            Node tr = list.top;
            while(tr.next!=null)
                tr = tr.next;
            tr.next = add;
        }
        return list;
    }
    
    public static void pop(DSA18L6E list)
    {
        if(list.top == null){}
        else if(list.top.next == null)
            list.top = null;
        else
        {
            Node tr = list.top;
            while(tr.next.next!=null)
                tr = tr.next;
            tr.next = null; 
        }
    }

    public static DSA18L6E increase(DSA18L6E list, long x, long d)
    {
        if(list.top == null)
            System.out.println("EMPTY");
        else
        {   
            int k = 0;
            Node tr = list.top;
            while(k != x)
            {
                tr.data += d;
                tr = tr.next;
                k++;
            }
        }
        return list;
    }

    public static void showTop(DSA18L6E list)
    {
        if(list.top==null)
            System.out.println("EMPTY");
        else
        {
            Node tr = list.top;
            while(tr.next!=null)
                tr = tr.next;
            System.out.println(tr.data);
        }
    }

    public static void display(DSA18L6E list)
    {
        Node tr = list.top;
        if(list.top == null)
            System.out.println("EMPTY");
        else
        {
            while(tr!=null)
            {
                System.out.print(tr.data + " -> ");
                tr = tr.next;
            }
            System.out.println();
        }  
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader cin = new BufferedReader (new InputStreamReader(System.in));
        DSA18L6E list = new DSA18L6E();

        int q = Integer.parseInt(cin.readLine());
        long d=0,c;
        while(q>0)
        {
            String[] ch = cin.readLine().split(" ");
            if(ch[0].equals("push"))
            {
                d = Integer.parseInt(ch[1]);
                list = push(list,d);
                showTop(list);
            }
            else if(ch[0].equals("inc"))
            {
                c = Integer.parseInt(ch[1]);
                d = Integer.parseInt(ch[2]);
                list = increase(list,c,d);
                showTop(list);
            }
            else
            {
                pop(list);
                showTop(list);
            }
            q--;
        }
    }
}