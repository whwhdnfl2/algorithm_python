N, K = map(int, input().split())

a = []

count = 0

for _ in range(N):
    a.append(int(input()))

for i in reversed(a):
    if K // i > 0:
        count += K // i
        K %= i
    else:
        pass

print(count)