N, M = map(int, input().split())
money = []
for i in range(N):
    money.append(int(input()))
data = [0] * 10001
for i in money:
    data[i] = 1


for i in range(money[len(money) - 1] + 1, M + 1):
    ans = 10001
    for j in money:
        if data[i - j] != 0:
            ans = min(ans, data[i - j] + 1)
    data[i] = ans


if data[M] == 10001:
    print(-1)
else:
    print(data[M])
