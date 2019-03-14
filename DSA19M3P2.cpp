#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int n;
    cin >> n;
    int a[n];
    for(int i=0 ; i<n ; i++)
        cin >> a[i];

    int stack[n];
    int top = -1;
    for(int i=0 ; i<n ; i++)
    {
        stack[++top] = a[i];
        while(top > 0 && stack[top] < 0 && stack[top-1] >= 0)
        {
            if ( (stack[top] + stack[top-1]) == 0 )
                top -= 2;
            else if( abs(stack[top]) > abs(stack[top-1]) )
            {
                stack[top-1] = stack[top];
                top--;
            }
            else
            {
                stack[top-1] = stack[top-1];
                top--;   
            }
        }
    }
    for(int i=0 ; i<=top ; i++)
        cout << stack[i] << " ";
    cout << endl;
    
    return 0;
}
