/*input

*/

import java.util.Scanner;
public class Lab_1
{
    static Scanner cin = new Scanner(System.in);
    
    public static int gotoRec(int[][] a,int n)
    {
        return points(a,n,0,0,0);
    }
    
    public static int points(int[][] a,int n,int i,int j,int p)
    {
        int r,d=0;
        int s; 
        if(i<0 || i==n)
            return 0;
        if(j==n || j<0)
            return 0;
        s = p + a[i][j];
        if(i==n-1 && j==n-1)
            return s;
        if(s>=1)
            d = points(a,n,i+1,j,s-1);
        r = points(a,n,i,j+1,s+1);

        return Math.max(r,d);
    }

    public static void main(String[] args) 
    {
        int a[][],i,j,n;
        n = cin.nextInt();
        a = new int[n][n];
        for (i=0;i<n;i++)
        {
            String temp = cin.next();
            for (j=0;j<n;j++)
                a[i][j] = Character.getNumericValue(temp.charAt(j));
        }
         System.out.println(gotoRec(a,n));
         cin.close();
    }
}