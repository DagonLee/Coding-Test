#include <cmath>
#include <iostream>
#include <vector>
using namespace std;

vector <pair<int, int> > adj;
int map[102][102];
bool visit[102];
string ans;
int n;

void init()
{
	for(int i = 0; i < 102; i++)
	{
		visit[i] = false;
		for(int j = 0; j < 102; j++)
		{
			map[i][j] = 0;
		}
	}
	
}

void dfs(int d_x, int e)
{
	
	visit[d_x] = true;
	if(d_x == e)
	{
		ans = "happy";
		return;
	}
	for(int k = 0; k < n + 2; k++)
	{
		if(map[d_x][k] == 1 && !visit[k] )
		{
			dfs(k, e);
		}
	}
}

int main()
{
	int t;
	int x;
	int y;

	cin >> t;	
	for(int i = 0; i < t; i++)
	{
		init();
		ans = "sad";
		adj.clear(); //벡터 초기화	
		cin >> n;
		for(int j = 0; j < n + 2; j++)
		{
			int x;
			int y;
			cin >> x >> y;
			adj.push_back(make_pair(x,y));
		}
		for(int i = 0; i < (adj.size() - 1); i++)
		{
			for(int j = 0; j < adj.size(); j++)
			{
				if(abs(adj[i].first - adj[j].first) + abs(adj[i].second - adj[j].second)  <= 1000)
				{
					map[i][j] =1;
				}
			}
		}

		dfs(0, n + 1);
		cout <<ans << endl;
	}
}
