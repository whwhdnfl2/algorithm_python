n, m, k = map(int, input().split())

data = list(map(int, input().split()))
data.sort(reverse=True)

count = 0
ans = 0
for i in range(m):
    count += 1
    if count > k:
        count = 0
        ans += data[1]
        continue
    ans += data[0]

print(ans)
