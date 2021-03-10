#include <iostream>
using namespace std;
int main() {
  int E, S, M;
  int e, s, m;

  cin >> E >> S >> M;
  e = s = m = 1;
  for (int i = 1;; i++)
  {
    if (e == E && s == S && m == M)
    {
      cout << i;
      break;
    }
    e += 1;
    s += 1;
    m += 1;
    if (e == 16)
    {
      e = 1;
    }
    if (s == 29)
    {
      s = 1;
    }
    if (m == 20)
    {
      m = 1;
    }
  }
}
