#include <iostream>
#include <vector>
using namespace std;

bool visit[1001];
vector <int> adj[1001];

void dfs(int start)
{
	visit[start] = true;
	for (int i = 0; i < adj[start].size(); i++)
	{
		int next = adj[start][i];
		if(!visit[next])
		{
			dfs(next);
		}
	}
}

int main()
{
	int node_num;
	int line_num;
	int cnt;

	cnt = 0;	
	cin >> node_num >> line_num;
	for (int i = 0; i < line_num; i++)
	{
		int a;
		int b;
		
		cin >> a >> b;
		adj[a].push_back(b);
		adj[b].push_back(a);
	}
	for (int i = 1; i <= node_num; i++)
	{
		if(!visit[i])
		{
			dfs(i);
			cnt++;
		}	
	}
	cout << cnt;
}
