#include <bits/stdc++.h>
using namespace std;

int binSearch(int *a , int low , int high , int x)
{
	int mid = (low+high)/2;
	if(low > high)
		return -1;
	else if(a[mid] == x)
		return mid+1;
	else if(a[mid] > x)
		return binSearch(a , low , mid-1 , x);
	return binSearch(a , mid+1 , high , x);
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int n , q;
	cin >> n >> q; 
	int a[n];
	for(int i=0 ; i<n ; i++)
		cin >> a[i];
	while(q--)
	{
		int x , y;
		cin >> x >> y;
		int px , py;
		px = binSearch(a , 0 , n-1 , x);
		py = binSearch(a , 0 , n-1 , y);
		cout << abs(px-py)+1 << endl;
	}
}
