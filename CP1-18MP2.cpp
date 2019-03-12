#include <bits/stdc++.h>
using namespace std;

void merge(long int a[] , long int s , long int e)
{
	long int mid = (s+e)/2;
	long int i = s;
	long int j = mid+1;
	long int k = s;

	long int temp[e+1];

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

void mergeSort(long int a[] , long int s , long int e)
{
	if(s>=e)
		return;
	
	long int mid = (s+e)/2;
	mergeSort(a,s,mid);
	mergeSort(a,mid+1,e);
	merge(a,s,e);
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	long int n,d;
	cin >> n;
	long int a[n];
	for(long int i=0;i<n;i++)
		cin >> a[i];

	mergeSort(a , 0 , n-1);
	d = a[1]-a[0];
	for(long int i=0;i<n-1;i++)
		if( (a[i+1]-a[i]) <= d )
			d = a[i+1]-a[i];

	cout << d << endl;	
	return 0;
}