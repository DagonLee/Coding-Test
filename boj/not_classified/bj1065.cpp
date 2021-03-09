#include <iostream>
using namespace std;

int han_num(int n)
{
	if(n <= 99)
	{
		return n;
	}
	else
	{
		if(n == 1000)
		{
			return 144;
		}
		else
		{
			int ans;
			int cnt;

			ans = 99;
			for(int i = 100; i <= n; i++)
			{
				int num = i;
				int arr[3] = {0, };

				cnt = 0;
				while(num != 0)
				{
					arr[cnt] = num % 10;
					num /= 10;
					cnt++;
				}
				if ((arr[2] - arr[1]) == (arr[1] - arr[0]))
					ans++;
			}
			return ans;
		}
	
	}
}
int main()
{
	int n;

	cin >> n;
	cout << han_num(n);
}
