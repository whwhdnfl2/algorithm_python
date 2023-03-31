T = int(input())

N, M = map(int, input().split())

array = list(map(int, input().split()))

dp = []
index = 0

for i in range(N):
    dp.append(array[index:index + M])
    index += M


for i in dp:
    print(i)
for i in range(1, M):
    for j in range(N): #n이 세로 m이 가로
        if j - 1 < 0 :
            dp[j][i] = max(dp[j + 1][i - 1] + dp[j][i], dp[j][i - 1] + dp[j][i])
        elif j + 1 == N:
            dp[j][i] = max(dp[j][i - 1] + dp[j][i], dp[j - 1][i - 1] + dp[j][i])
        else:
            dp[j][i] = max(dp[j + 1][i - 1] + dp[j][i], dp[j][i - 1] + dp[j][i], dp[j - 1][i - 1] + dp[j][i])
for i in dp:
    print(i)