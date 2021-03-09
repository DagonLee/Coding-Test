#include <iostream>
using namespace std;

int main()
{
	int A;
	int B;
	int C;
	
	A = 0;
	B = 0;
	C = 0;
	cin >> A >> B >> C;
	if((C - B) <= 0)
	{
		cout << -1;
		return 0;
	}
	else
	{
		int n;
		
		n = (A / (C - B)) + 1;
		cout << n;
	}
}	
