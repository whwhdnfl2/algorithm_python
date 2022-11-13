
N, K = map(int, input().split())


d = [0] * (K + 1)
array = []
for i in range(N):
    a, b = map(int, input().split())
    array.append((a, b))

for thing in array:
    for i in range(K, thing[0] - 1, -1):
        if(d[i] < d[i - thing[0]] + thing[1]):
            d[i] = d[i - thing[0]] + thing[1]


ans = 0
for j in d:
    if j > ans:
        ans = j
print(ans)