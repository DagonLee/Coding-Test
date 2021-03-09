#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int map[101][101][101];
int dir[6][3] = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};
queue <vector<int> > q;

int col;
int row;
int height;

void bfs()
{
	while(!q.empty())
	{
		int z = q.front()[0];
		int y = q.front()[1];
		int x = q.front()[2];
		
		q.pop();
		for(int i = 0 ; i <6; i++)
		{
			int new_z = z + dir[i][0];
			int new_y = y + dir[i][1];
			int new_x = x +	dir[i][2];
			if(0 <= new_z && new_z < height && 0 <= new_y && new_y < row && 0 <= new_x && new_x < col) 
			{	
				if(map[new_z][new_y][new_x] == 0)
				{
					map[new_z][new_y][new_x] = map[z][y][x] + 1;
					vector<int> tmp;
					tmp.push_back(new_z);
					tmp.push_back(new_y);
					tmp.push_back(new_x);
					q.push(tmp);
				}
			}
		}
	}
}
int main()
{
	int cnt;
	
	cnt = 0;
	cin >> col >> row >> height;
	for(int k = 0; k < height; k++)	
	{
		for(int i=0; i < row; i++)
		{
			for(int j = 0; j <col; j++)		
			{
				cin >> map[k][i][j];
				if(map[k][i][j] == 1)
				{
					vector<int> tmp;
					tmp.push_back(k); 
					tmp.push_back(i); 
					tmp.push_back(j); 
					q.push(tmp);
				}
				if(map[k][i][j] == 0)
					cnt++;
			}
		}
	}
	bfs();
	if(cnt == 0)
	{
		cout << 0;
		return 0;
	}
	int max = -1;
	for(int k = 0; k < height; k++)	
	{
		for(int i=0; i < row; i++)
		{
			for(int j = 0; j <col; j++)		
			{
				if(map[k][i][j] == 0)
				{
					cout << -1;
					return 0;
				}
				if(map[k][i][j] > max)
				{
					max = map[k][i][j];
				}
			}
		}
	}
	cout << max-1;
}
