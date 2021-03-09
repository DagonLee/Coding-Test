#include <iostream>
#include <queue>
using namespace std;

int map[1000001];
bool visit[10000001]= {false,};
queue <int> q;
int f;
int s;
int g;
int u;
int d;
void bfs(int start)
{
	int dir[2] ={u,-d};
	q.push(start);
	visit[start] = true;
	while(!q.empty())
	{
		int now = q.front();
		q.pop();
		for(int i = 0; i < 2; i++)
		{
			int next = now + dir[i];
			if(0 < next && next <= f)
			{
				if(!visit[next])
				{
					map[next] = map[now] + 1;
					q.push(next);
					visit[next] = true;
				}
			}
		}	
	}	
}

int main()
{

	cin >> f >> s >> g >> u >> d;
	
	bfs(s);
	if (s == g) 
	{
		cout << 0;
	}
	else
	{
		if(map[g] == 0)
			cout<< "use the stairs";
		else
			cout << map[g];
	}
}
