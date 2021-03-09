#include <iostream>
#include <queue>
using namespace std;

queue <pair<int, int> > q;
bool visit[101][101];
int dir[4][2] = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}}; 
int map[101][101];
int n;

void init()
{
	for(int i = 0; i<100; i++)
	{
		for(int j = 0; j<100; j++)
		{
			visit[i][j] = false;
		}
	}
}

void dfs(int y, int x, int l)
{
	visit[y][x] = true;
	for(int i = 0; i < 4; i++)
	{
		int new_y = y + dir[i][0];
		int new_x = x +	dir[i][1];
		if(0 <= new_y && new_y < n && 0 <= new_x && new_x < n)
		{
			if(!visit[new_y][new_x] && map[new_y][new_x] > l)
			{
				dfs(new_y,new_x,l);
			}
		}
	}
}

int main()
{
	int min;
	int max;
	int ans;
	
	ans = 0;
	min = 101;
	max = -1;
	cin >> n;
	for(int i = 0; i < n; i++)
	{
		for(int j = 0; j < n; j++)
		{
			cin >> map[i][j];
			if( map[i][j] < min)
				min = map[i][j];
			if(map[i][j] > max)
				max = map[i][j];
		}
	}
	if( min == 0)
		min = 1;
	for(int i = (min - 1); i <= max; i++)
	{
	
		int cnt;
		init();
		cnt = 0;
		for(int j = 0; j < n; j++)
		{
			for(int k = 0; k < n; k++)
			{
				if(!visit[j][k] && (map[j][k] > i))
				{
					dfs(j, k, i);
					cnt++;
				}
			}
		}
		if(cnt > ans)
			ans = cnt;	
		
	}
	cout << ans;
}
