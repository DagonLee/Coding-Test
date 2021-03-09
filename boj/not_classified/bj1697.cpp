#include<iostream>
#include<queue>
using namespace std;
int cnt;
int n;
int k;
queue <int> q;
int route[3] = {-1,1,2};
int map[100001];
bool visit[100001];

void bfs(int start)
{	
	visit[start] = true;
	q.push(start);
	while(!q.empty())
	{
		int now = q.front();
		if(now == k)
			return;	
		q.pop();
		for(int i = 0; i < 3; i++)
		{
			if(i == 2)
			{
				if((now *route[i]) <= 100000)
				{
					if(visit[now *route[i]] ==false)
					{
						q.push(now * route[i]);
						map[now * route[i]] = map[now] + 1;
						visit[now *route[i]] = true;
						if((now * route[i]) == k)
							return;	
					}
				}
			}
			else
			{
				if((now + route[i]) >= 0 && (now + route[i] <= 100000))
				{
					if(visit[now + route[i]] == false)
					{
						q.push(now + route[i]);
						map[now +route[i]] = map[now] + 1;
						visit[now +route[i]] = true;
						if((now + route[i]) == k)
							return;
					}
				}
			}
		}
	}
}

int main()
{
	cnt = 0;
	cin >> n >> k;
	bfs(n);
	cout << map[k];
}
