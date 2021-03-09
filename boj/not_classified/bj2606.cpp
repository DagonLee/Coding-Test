#include <iostream>
#include <vector>

using namespace std;

int cnt;
vector <int> adj[101];
bool visit[101];

void dfs(int start)
{
	visit[start] = true;
	for(int i = 0; i < adj[start].size(); i++)
	{
		int next = adj[start][i];
		if(!visit[next])
		{
			cnt++;
			dfs(next);
		}
	}
}
int main()
{
	int node_num;
	int line_num;
	cin >> node_num;
	cin >> line_num;
	for(int i = 0; i < line_num; i++)
	{
		int a;
		int b;
		cin >> a >> b;
		adj[a].push_back(b);
		adj[b].push_back(a);
	}
	cnt = 0;
	dfs(1);	
	cout << cnt;
}
