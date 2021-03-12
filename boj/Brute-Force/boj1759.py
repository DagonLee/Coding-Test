l, c = map(int,input().split())
lst = list(input().split())
lst.sort()
def correct(ans):
  mo = 0
  ja = 0
  for i in ans:
    if i in ['a','e','i','o','u']:
      mo += 1
    else:
      ja += 1
  if mo >= 1 and ja >= 2:
    return True
  return False
def go(idx, ans):
  if len(ans) == l:
    tmp = ''.join(ans)
    if correct(ans):
      print(tmp)
    return
  if idx == c:
    return
  ans.append(lst[idx])
  go(idx + 1, ans)
  ans.pop()
  go(idx + 1, ans)

go(0, [])
