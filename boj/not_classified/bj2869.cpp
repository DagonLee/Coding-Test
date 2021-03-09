#include <iostream>
#include <cmath>
using namespace std;

int main()
{
	int A;
	int B;
	int V;
	int cnt;
	int sum;

	cin >> A >> B >> V;
	if(A >= V)
	{
		cout << 1;
	}
	else
	{
		cout << (int)(ceil((float)(V - A) / (float)(A - B) + 1));
	}
	
}
