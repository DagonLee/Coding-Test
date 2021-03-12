n = int(input())
def go(s, m):
  if s == m:
    return 1
  if s > m:
    return 0
  ans = 0
  ans += (go(s + 1, m) + go(s + 2, m) + go(s + 3, m))
  return ans
for _ in range(n):
  print(go(0,int(input())))
