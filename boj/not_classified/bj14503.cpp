#include<iostream>
using namespace std;

int row;
int col;
int map[51][51];
bool visit[51][51];
int cnt;
int route[4][2] = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
int back[4][2]  = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

bool check(int r, int c)
{
	for(int i = 0; i < 4; i++)
	{
		int new_r;
		int new_c;

		new_r = r + route[i][0];
		new_c = c + route[i][1];
			
		if(0 <= new_r && new_r < row && 0 <= new_c && new_c < col)
		{
			if(!visit[new_r][new_c] && map[new_r][new_c] == 0)
			{
				return true;
			}
		}
	}
	return false;
}

void dfs(int r, int c, int dir)
{
	visit[r][c] = true;
	int new_r = r + route[dir][0];
	int new_c = c + route[dir][1];
	if(0 <= new_r && new_r < row && 0 <= new_c && new_c < col)
	{
		if(!visit[new_r][new_c] && map[new_r][new_c] == 0)
		{
			dir = dir - 1;
			if(dir == -1)
			{
				dir = 3;
			}
			cnt++;
			dfs(new_r, new_c, dir);
		}
		else
		{
			if(!check(r, c))
			{
				int back_r;
				int back_c;
				back_r = r + back[dir][0];
				back_c = c + back[dir][1];
				if(0 <= back_r && back_r < row && 0 <= back_c && back_c < col)
				{
					if(map[back_r][back_c] == 0)
					{
						if(!visit[back_r][back_c])
							cnt++;
						dfs(back_r, back_c, dir);
					}
				}
			}
			else
			{
				dir = dir - 1;
				if(dir == -1)
				{
					dir = 3;
				}
				dfs(r, c, dir);
			}
		}
	}
}

int main()
{
	int r;
	int c;
	int dir;
	cnt = 0;
	cin >> row >> col;
	cin >> r >> c >> dir;
	for(int i = 0; i < row; i++)
	{
		for(int j = 0; j < col; j++)
		{
			cin >> map[i][j];
		}
	}
	if(map[r][c] == 0)
	{
		cnt = 1;
	}
	dfs(r, c, dir);
	cout << cnt;
}
