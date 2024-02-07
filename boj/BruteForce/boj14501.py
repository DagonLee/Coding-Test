n = int(input())
lst = []
for i in range(n):
  lst.append(list(map(int, input().split())))
ans = 0
def go(day, s):
  if day == n:
    global ans
    ans = max(ans, s)
    return
  if day > n:
    return
  go(day + lst[day][0], s + lst[day][1])
  go(day + 1, s)

go(0,0)
print(ans)
