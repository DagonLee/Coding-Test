#include <iostream>
using namespace std;

int main()
{
	int a,b,c;
	scanf("%d %d %d",&a,&b,&c);
		
	if((b - a) > (c - b))
	{
		printf("%d\n",(b - a - 1));
	}
	else
	{
		if((c-b) == 1)
		{
			printf("%d\n",0);
		}
		else
		{
			printf("%d\n",(c - b - 1));
		}
	}
}
