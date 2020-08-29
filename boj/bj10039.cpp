#include <iostream>
using namespace std;

int main()
{
	int arr[5];
	int ans;

	ans = 0;
	for(int i = 0; i < 5; i++)
	{
		int tmp;
		cin >> tmp;
		if(tmp < 40)
			tmp = 40;
		ans += tmp;
	}
	cout << ans/5;
}
