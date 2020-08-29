#include <iostream>
using namespace std;

int main()
{
	int n;
	int cnt;
	int sum;

	cin >> n;
	cnt = 1;
	sum = 1; 
	while(1)
	{
		if(n <= sum)
			break;
		sum = (6 * cnt) + sum;
		cnt++;
	}
	cout << cnt;
}
