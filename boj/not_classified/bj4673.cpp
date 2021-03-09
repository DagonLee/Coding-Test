#include <iostream>
using namespace std;
int self_num(int n)
{
	int num;
	int sum;
	
	num = n;
	sum = n;
	while(n != 0)
	{
		sum += (n % 10);
		n /= 10;
	}
	return sum;
}
int main()
{
	int arr[10036] = {0, };
	for(int i = 1; i <= 10000; i++)
	{
		arr[self_num(i)] = 1;
		if(!arr[i])
			cout << i << endl;
	}
}
