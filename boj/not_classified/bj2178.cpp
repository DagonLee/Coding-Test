#include <iostream>
#include <queue>

using namespace std;
int map[101][101];
int ans[101][101];
int dir[4][2] = {{1,0},{-1,0},{0,-1},{0,1}};
bool visited[101][101];
queue<pair <int, int> > q;
int N;
int M;

void bfs()
{
	q.push(make_pair(0,0));
	visited[0][0] = true;
	ans[0][0] = 1;
	while(!q.empty())
	{
		int y = q.front().first;
		int x = q.front().second;
		
		visited[y][x] = true;
	
		if(y == N-1 && x == M-1)
		{
			return;
		}
		q.pop();
		for(int i = 0; i < 4; i++)
		{
			int new_y = y + dir[i][0];
			int new_x = x + dir[i][1];
			
			if(0 <= new_y && new_y < N && 0 <= new_x && new_x < M)
			{
				if(!visited[new_y][new_x] && map[new_y][new_x] == 1)
				{
					visited[new_y][new_x] = true;
					ans[new_y][new_x] = ans[y][x] + 1;
					q.push(make_pair(new_y, new_x));
				}
			}						
		}
	}
}	
int main()
{
	cin >> N >> M;
	for(int i = 0; i < N; i++)
	{
		for(int j = 0; j < M; j++)
		{
			scanf("%1d", &map[i][j]);
			ans[i][j] = 0;
		}
	}
	bfs();
	cout << ans[N-1][M-1] << endl;
}
