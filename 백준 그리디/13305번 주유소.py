N = int(input())
load = []
city = []

load = list(map(int, input().split()))

city = list(map(int, input().split()))

fee = city[0]

ans = 0

for i in range(N):
    if fee > city[i]:
        fee = city[i]
    if i == N-1:
        pass
    else:
        ans += fee * load[i]

print(ans)
