n = int(input())
op = list(input().split())
g_max = -1
g_min  = 9876543210
check = [0] * 10
def calculate(ans):
  for i in range(n):
    if op[i] == '<':
      if ans[i] > ans[i + 1]:        
        return False
    elif op[i] == '>':
      if ans[i] < ans[i + 1]:
        return False
  return True
def go(idx, ans):
  if idx == n + 1:
    if calculate(ans):
      global g_max
      global g_min
      tmp = ''.join(map(str,ans))
      g_max = max(g_max, int(tmp))
      g_min = min(g_min, int(tmp))
    return
  for i in range(10):
    if check[i] != 1:
      ans.append(i)
      check[i] = 1
      go(idx + 1, ans)
      ans.pop()
      check[i] = 0


go(0, [])
if len(str(g_max)) < n + 1:
  print('0' + str(g_max))
else:
  print(g_max)
if len(str(g_min)) < n + 1:
  print('0' + str(g_min))
else:
  print(g_min)
