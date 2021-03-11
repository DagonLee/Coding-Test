n = int(input())

lst = [list(map(int, input().split()))for _ in range(n)]
ans = 40000
def calculate(a,b):
  sum_a = 0
  for i in range(len(a)):
    for j in range(i, len(a)):
      sum_a += (lst[a[i]][a[j]] + lst[a[j]][a[i]])
  sum_b = 0
  for i in range(len(b)):
    for j in range(i, len(b)):
      sum_b += (lst[b[i]][b[j]] + lst[b[j]][b[i]])
  return (abs(sum_a - sum_b))

def go(idx, a, b):
  if idx == n:
    if len(a) != 0 and len(b) != 0:
      global ans
      ans = min(ans, calculate(a,b))
      print(a, b)
    return
  a.append(idx)
  go(idx + 1, a, b)
  a.pop()
  b.append(idx)
  go(idx + 1, a, b)
  b.pop()
go(0, [], [])
print(ans)
