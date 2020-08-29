#include <iostream>
using namespace std;

bool visit[300][300];
int map[300][300];
int dir[4][2] = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
int n,m;
void init()
{
	for(int i = 0; i < n; i++)
	{
		for(int j = 0; j < m; j++)
		{
			visit[i][j] = false;
		}
	}
}
void dfs(int y, int x)
{
	visit[y][x] = true;
	for(int i = 0; i < 4; i++)
	{
		int new_y;
		int new_x;

		new_y = y + dir[i][0];
		new_x = x + dir[i][1];
		if(map[new_y][new_x] != 0 && !visit[new_y][new_x])
		{
			dfs(new_y, new_x);
		}
	}
}


int count(int y, int x)
{
	int cnt;
	
	cnt = 0;
	for(int i = 0; i < 4; i++)
	{
		int new_y;
		int new_x;

		new_y = y + dir[i][0];
		new_x = x + dir[i][1];
		if(map[new_y][new_x] == 0)
			cnt++;
	}
	return cnt;
}
void melt()
{
	int new_map[300][300];

	for(int i = 0; i < n ; i++)
	{
		for(int j = 0; j < m; j++)
		{
			if(map[i][j] != 0)
			{
				new_map[i][j] = map[i][j] - count(i, j);
			}
			else
			{
				new_map[i][j] = map[i][j];
			}
			if(new_map[i][j] < 0 )
				new_map[i][j] = 0;
		}
	}	

	for(int i = 0; i < n; i++)
	{
		for(int j = 0; j < m; j++)
		{
			map[i][j] = new_map[i][j];
		}
	}	
}

int main()
{
	int ans;
	int cnt;
	
	cnt = 0;
	ans = -1;
	cin >> n >> m;
	for(int i = 0; i < n; i++)
	{
		for(int j = 0; j < m; j++)
		{
			cin >> map[i][j];
		}
	}

	while(1)
	{
		ans++;
		cnt = 0;
		init();
		
		for(int i = 1; i < (n - 1); i++)
		{
			for(int j = 1; j < (m - 1); j++)
			{
				if(!visit[i][j] && map[i][j] != 0)
				{
					cnt++;
					dfs(i, j);
				}
			}
		}
		if(cnt >= 2)
		{
			
			cout <<ans;
			return 0;
		}
		if(cnt == 0)
			break;
		melt();
	}
	cout << 0;
}
