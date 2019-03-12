import java.util.Scanner;

public class DSA19L6_1
{
	public static int push(int val,int[] stack, int top)
	{
		top++;
		stack[top]=val;
		return top;
	}
	
	public static int pop(int[] stack, int top)
	{
		stack[top]=0;
		return --top;
	}

	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		int n= s.nextInt();
		int[] arr=new int[n];
		for (int i=0;i<n;i++)
			arr[i]=s.nextInt();
	        
		int[] stack=new int[n];
		int[] ans=new int[n];
		int index=n-1;
		int top=-1;
		
		top=push(arr[n-1],stack,top);
		ans[index]=-1;
		index--;
		for (int i=n-2 ; i>=0 ; i--)
		{
			while(top!=-1 && stack[top]<=arr[i])
				top=pop(stack,top);

			if(top!=-1 && stack[top]!=arr[i])	
				ans[index--]=stack[top];
			else
				ans[index--]=-1;
	        top=push(arr[i],stack,top);
	    }
	    for (int i=0 ; i<n ; i++)
	    {
	    	System.out.print(ans[i]);
	    	if(i!=n-1)
	    		System.out.print(" ");
	    }
	    System.out.println();
	}
}
