#include <iostream>
using namespace std;

int main()
{
	int n;
	int cnt;
	int sum;
	int seq;

	cnt = 1;
	sum = 1;	
	cin >> n;
	while(1)
	{
		if(n <= sum)
			break;
		sum = (cnt + 1) + sum;
		cnt++;
	}	
	seq = n - (sum - cnt);
	if((cnt + 1) % 2 == 0)
	{
		cout << (cnt + 1 -seq) << '/' << seq;
	}
	else
	{
		cout << seq << '/' << (cnt + 1 - seq) ;
	}
}
