#include <iostream>
using namespace std;

int main()
{
	int bur[3] = {0,};
	int bev[2] = {0,};
	int bur_min;
	int bev_min;

	bur_min = 2001;
	bev_min = 2001;
	for(int i = 0; i < 3; i++)
	{
		cin >> bur[i];
		if( bur[i] < bur_min)
		{
			bur_min = bur[i];
		}
	}
	for(int j = 0; j < 2; j++)
	{
		cin >> bev[j];
		if(bev[j] < bev_min)
		{
			bev_min = bev[j];
		}
	}
	cout << (bev_min + bur_min -50);
}
