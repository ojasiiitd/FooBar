import java.util.Scanner;

public class DSA18L1P1
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int a[],n;
		n = in.nextInt();
		a = new int[n];
		int i;
		for(i=0;i<n;i++)
			a[i] = in.nextInt();
		long s=0;
		for(i=0;i<n;i++)
		{
			if(n==1)
			{
				if(a[i]>=1 && a[i]<=10)
					s+=2;
				else if(a[i]>=11 && a[i]<=20)
					s+=3;
				else if(a[i]>=21 && a[i]<=30)
					s+=4;
				else if(a[i]>=31 && a[i]<=40)
					s+=5;
				else if(a[i]>=41 && a[i]<=50)
					s+=6;
			}
			else if(i==0 && a[0]>a[1])
			{
				if(a[i]>=1 && a[i]<=10)
					s+=2;
				else if(a[i]>=11 && a[i]<=20)
					s+=3;
				else if(a[i]>=21 && a[i]<=30)
					s+=4;
				else if(a[i]>=31 && a[i]<=40)
					s+=5;
				else if(a[i]>=41 && a[i]<=50)
					s+=6;
			}
			else if(i==(n-1) && a[n-1]>a[n-2])
			{
				if(a[i]>=1 && a[i]<=10)
					s+=2;
				else if(a[i]>=11 && a[i]<=20)
					s+=3;
				else if(a[i]>=21 && a[i]<=30)
					s+=4;
				else if(a[i]>=31 && a[i]<=40)
					s+=5;
				else if(a[i]>=41 && a[i]<=50)
					s+=6;
			}
			else if(i!=0 && i!=(n-1) && a[i]>a[i+1] && a[i]>a[i-1])
			{
				if(a[i]>=1 && a[i]<=10)
					s+=2;
				else if(a[i]>=11 && a[i]<=20)
					s+=3;
				else if(a[i]>=21 && a[i]<=30)
					s+=4;
				else if(a[i]>=31 && a[i]<=40)
					s+=5;
				else if(a[i]>=41 && a[i]<=50)
					s+=6;
			}
			else
			{
				
			}
		}
		System.out.println(s);
		in.close();
	}
}