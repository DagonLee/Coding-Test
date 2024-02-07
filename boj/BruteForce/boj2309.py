lst = []
for _ in range(9):
    lst.append(int(input()))
    s = sum(lst)
    for i in range(9):
        for j in range(i + 1, 9):
            if s - lst[i] - lst[j] == 100:
                for k in range(0, 9):
                    if i == k or j == k:
                        continue
                    print(lst[k])
lst.sort()
