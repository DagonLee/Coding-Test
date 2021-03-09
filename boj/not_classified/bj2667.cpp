#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int map[26][26];
bool visit[26][26];
int N;
int dir[4][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
int cnt;
vector <int> houses;

void dfs(int y, int x)
{
	cnt ++;
	visit[y][x] = true;
	for(int k = 0; k < 4; k++)
	{
		int new_y = y + dir[k][0];
		int new_x = x + dir[k][1];
		
		if(0 <= new_x && new_x < N && 0 <= new_y && new_y < N)
		{
			if(!visit[new_y][new_x] && map[new_y][new_x] == 1)
			{
				dfs(new_y,new_x);
			}
		}
	}
}
int main()
{
	cin >> N;
	for(int i = 0; i < N; i++)
	{
		for(int j = 0; j < N; j++)
		{
			scanf("%1d",&map[i][j]);
		}
	}
	for(int y = 0; y < N; y++)
	{
		for(int x = 0; x < N; x++)
		{
			if(!visit[y][x] && map[y][x] == 1)
			{
				cnt = 0;
				dfs(y, x);
				houses.push_back(cnt);
			}
		}
	}
	sort(houses.begin(),houses.end());
	cout << houses.size() << endl;
	for(int i=0; i < houses.size(); i++)
	{
		cout << houses[i] << endl ;
	}
}
