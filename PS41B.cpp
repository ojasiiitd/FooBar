#include <iostream>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
    cin.tie(0);

    int n;
    cin >> n;
    int a[n];
    for(int i=0 ; i<n ; i++)
        cin >> a[i];
    int s = 0 , max;
    for(int i=0 ; i<2 ;i++)
        s += a[i];
    max = s;
    int i = 0 , j = 1;
    while(j < n-1)
    {
        s -= a[i++];
        s += a[++j];
        if(s > max)
            max = s;
    }
    cout << max << endl;
	return 0;
}