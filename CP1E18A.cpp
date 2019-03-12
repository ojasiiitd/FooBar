#include <bits/stdc++.h>
using namespace std;

void merge(int a[] , int s , int e)
{
	int mid = (s+e)/2;
	int i = s;
	int j = mid+1;
	int k = s;

	int temp[e+1];

	while(i<=mid && j<=e)
	{
		if(a[i]<a[j])
			temp[k++] = a[i++];
		else
			temp[k++] = a[j++];
	} 
	while(i<=mid)
		temp[k++] = a[i++];
	while(j<=e)
		temp[k++] = a[j++];

	for(i=s;i<=e;i++)
		a[i] = temp[i];
}

void mergeSort(int a[] , int s , int e)
{
	if(s>=e)
		return;
	
	int mid = (s+e)/2;
	mergeSort(a,s,mid);
	mergeSort(a,mid+1,e);
	merge(a,s,e);
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int t,n,b;
	cin >> t;
	while(t--)
	{
		cin >> n >> b;
		int i,a[n];
		for(i=0;i<n;i++)
			cin >> a[i];
		mergeSort(a,0,n-1);
		
		int sum = 0, items = 0;
		for(i=0;i<n;i++)
		{	
			sum += a[i];
			if(sum<=b)
				items++;
			else
				break;
		}

		cout << items << endl;
	}
	return 0;
}