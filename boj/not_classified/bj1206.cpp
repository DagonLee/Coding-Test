#include <vector>
#include <iostream>
#include <queue>
using namespace std;

vector<int> adj[1001];
bool visit[1001];
queue <int> que;
void init()
{
	for (int i=0; i<=1001; i++)
	{
		visit[i] =false;
	}
}

void dfs(int cur)
{
	visit[cur] = true;
	cout << cur << ' ' ;
	for (int i=0; i < adj[cur].size(); i++)
	{
		int next = adj[cur][i];
		if (visit[next]) continue;
		dfs(next);
	}
}

void bfs(int start)
{
	visit[start] = true;
	que.push(start);
	while(!que.empty())
	{
		int x = que.front();
		cout << que.front() << ' ';
		que.pop();
		for (int i = 0; i< adj[x].size(); i++)
		{
			int next = adj[x][i];
			if (!visit[next])
			{
				visit[next] =true;
				que.push(next);
			}

		}
	}
}	

int main()
{
	int node_num;
	int line_num;
	int start;

	cin >> node_num >> line_num >> start;
	for (int i = 0; i < line_num; i++)
	{
		int a,b;
		cin >> a >> b;
		adj[a].push_back(b);
		adj[b].push_back(a);
	}
	for (int j = 1; j <= node_num; j++)
	{
		sort(adj[j].begin(),adj[j].end());
	}
	dfs(start);
	cout <<endl;
	init();
	bfs(start);
}
