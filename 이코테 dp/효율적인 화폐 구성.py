N, M = map(int, input().split())

array = []
for _ in range(N):
    array.append(int(input()))

d = [10001] * (M + 1)

d[0] = 0
for i in array:
    for j in range(i, M + 1):
        if d[j - i] != 10001:
            d[j] = min(d[j], d[j - i] + 1)

if d[M] == 10001:
    print("asdasd")
else:
    print(d[M])

print(d)