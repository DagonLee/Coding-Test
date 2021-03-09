#include <iostream>
using namespace std;

int main()
{
	int n;

	cin >> n;
	for(int i = 1; i < (2 * n); i++)
	{
		if(i > n)
		{
			for(int j = 0; j < (n - (i - n)); j++)
			{
				cout << '*' ;
			}
			cout << endl;
		}
		else
		{
			for(int j = 0; j < i; j++)
			{
				cout << '*';
			}
			cout <<endl;
		}
	}
}
