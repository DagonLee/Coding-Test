#include <iostream>
#include <queue>
using namespace std;

int map[1001][1001];
int ans[1001][1001];
int dir[4][2] = {{-1,0},{1,0},{0,-1},{0,1}};
queue <pair<int, int> > q;
int row;
int col;

void bfs()
{
	while(!q.empty())
	{
		int y = q.front().first;
		int x = q.front().second;

		q.pop();
		for(int i = 0; i < 4; i ++)
		{
			int new_y = y + dir[i][0];
			int new_x = x + dir[i][1];
			
			if(0 <= new_y && new_y < row && 0 <= new_x && new_x < col)
			{
				if(ans[new_y][new_x] == 0 && map[new_y][new_x] == 0)
				{
					ans[new_y][new_x] = ans[y][x] + 1;
					map[new_y][new_x] = 1;
					q.push(make_pair(new_y,new_x));
				}
			}
		}
	}
} 				
		
int main()
{
	
	cin >> col >> row;
	for(int i = 0; i < row; i++)
	{
		for(int j = 0; j < col; j++)
		{
			cin >>map[i][j];
		}
	}
	for(int i = 0; i < row; i++)
	{
		for(int j = 0; j < col; j++)
		{
			if(map[i][j] == 1)
			{
				q.push(make_pair(i,j));
			}
		}
	}
	bfs();
	int max = -1;
	for(int i = 0; i < row; i++)
	{
		for(int j = 0; j < col; j++)
		{
			if(map[i][j] == 0)
			{
				cout << -1 ;
				return 0;
			}
		}	
	}
	for(int i = 0; i < row; i++)
	{
		for(int j = 0; j < col; j++)
		{
			if(ans[i][j] > max)
			{
				max = ans[i][j];
			}
		}	
	}
	cout << max;
}
