#include <bits/stdc++.h>
using namespace std;

bool missingPresent(int *a , int l , int x)
{
	for(int i=0 ; i<l ; i++)
		if(a[i] == x)
			return true;
	return false;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int n, k;
	cin >> n >> k;
	n *= n;
	int a[k];
	for(int i=0 ; i<k ; i++)
		cin >> a[i];

	int fullSum = 0;
	for(int i=0 ; i<k ; i++)
		fullSum += a[i];
	if(fullSum == n)
	{
		cout << "YES" << endl;
		exit(0);
	}

	int missing = abs(fullSum - n);
	if(missingPresent(a , k , missing))
		cout << "YES" << endl;
	else
		cout << "NO" << endl;

	return 0;
}