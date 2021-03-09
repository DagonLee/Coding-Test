n = int(input())

lst = [0] + list(map(int, input().split()))
d = [0] * (n + 1)
for i in range(1, n + 1):
    for j in range(1, i + 1):
        if d[i - j] + lst[j] > d[i]:
            d[i] = d[i - j] + lst[j]
print(d[n])

