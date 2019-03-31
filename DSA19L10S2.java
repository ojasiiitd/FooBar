// oju

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

class Graph 
{
    int n;
    List<Integer> adjList[];
    boolean visited[];

    
    Graph(int v)
    {
    	n = v;
        visited = new boolean[v];
        adjList = new List[v];

        for(int i=0; i<v ; i++)
        {
            adjList[i] = new ArrayList<Integer>();
            visited[i] = false;
        }
    }

    void BFSanswer(int a , int k[])
    {   
        visited = new boolean[n];

        LinkedList<Integer> q = new LinkedList<>();
        ArrayList<Integer> temp = new ArrayList<Integer>();

        q.add(a-1);
        visited[a-1] = true;

        while(q.size() > 0)
        {
            int cur = q.poll();
            for(int x : adjList[cur])
            {   
                if(visited[x] == false)
                {
                    q.addLast(x);
                    visited[x] = true;
                    temp.add(x);
                }
            }
        }

        int min = -1;
        if(temp.size() > 0)
            min = k[temp.get(0)];
        for(int i=0 ; i<temp.size() ; i++)
            if(k[temp.get(i)] < min)
                min = k[temp.get(i)];

        System.out.println(min);
    }

    void print()
    {
        for(int i=0 ; i<n ; i++)
        {   
            System.out.print(i + " : ");
            for (int x : adjList[i])
                System.out.print(x + " ");
            System.out.println();
        }
    }
}

public class DSA19L10S2
{
	public static void main(String args[])
	{
		Scanner cin = new Scanner(System.in);

		int t = cin.nextInt();
		while(t-- > 0)
		{			
			int n = cin.nextInt();

			Graph g = new Graph(n);

			int k[] = new int[n];
			
			for(int i=0 ; i<n ; i++)
				k[i] = cin.nextInt();

			int m = cin.nextInt();

			for(int i=0 ; i<m ; i++)
			{
                int x = cin.nextInt();
                int y = cin.nextInt();
                g.adjList[y-1].add(x-1);
			}

            // g.print();

			int q = cin.nextInt() , a;

			for(int i=0 ; i<q ; i++)
			{
				a = cin.nextInt();
                g.BFSanswer(a , k);
			}
		}
		
		cin.close();
	}
}