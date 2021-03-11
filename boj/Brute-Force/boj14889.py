n = int(input())

ans = 40000
lst = [list(map(int,input().split()))for _ in range(n)]
def cal(a,b):
  sum_a = 0
  sum_b = 0
  for i in range(n // 2):
    for j in range(i + 1, n // 2):
      sum_a += (lst[a[i]][a[j]] + lst[a[j]][a[i]])
      sum_b += (lst[b[i]][b[j]] + lst[b[j]][b[i]])
  return abs(sum_a - sum_b)
def go(a, b, idx):
  if len(a) == n // 2 and len(b) == n // 2:
    global ans
    ans = min(ans, cal(a,b))
    return
  
  if idx == n:
    return
  a.append(idx)
  go(a, b, idx + 1)
  a.pop()
  b.append(idx)
  go(a, b, idx + 1)
  b.pop()

go([], [], 0)
print(ans)
