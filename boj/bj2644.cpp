#include <iostream>
#include <vector>
#include <queue>
using namespace std;

queue <int> q;
vector <int> map[101];
bool visit[101];
int depth[101];
int ans;
int cnt;

void bfs(int start)
{
	q.push(start);
	visit[start] = true;
	while(!q.empty())
	{	
		int now = q.front();
		q.pop();
		for(int i = 0; i < map[now].size(); i++)
		{
			int next = map[now][i];
			if(!visit[next])
			{
				visit[next] = true;
				q.push(next);
				depth[next] = depth[now] + 1;	
			}
		}
	}
}

int main()
{
	int node_num;
	int start;
	int target;
	int line_num;
	
	ans = 0;
	cnt = -1;
	cin >> node_num;
	cin >> start >> target;
	cin >> line_num;
	for(int i = 0; i < line_num; i++)
	{
		int a;
		int b;
		cin >> a >> b;
		map[a].push_back(b);		
		map[b].push_back(a);
	}
	bfs(start);
	if(depth[target] != 0)
		cout << depth[target] << endl;
	else
		cout << -1;
}
