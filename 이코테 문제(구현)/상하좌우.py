N = int(input())
A = list(map(str, input().split()))

ans = [1, 1]
dx = [0, 0, 1, -1] #RLDU
dy = [1, -1, 0, 0]

for i in A:
    if i == 'R' and ans[1] < N:
        ans[0] += dx[0]
        ans[1] += dy[0]
    elif i == 'L' and ans[1] > 1:
        ans[0] += dx[1]
        ans[1] += dy[1]
    elif i == 'D' and ans[0] < N:
        ans[0] += dx[2]
        ans[1] += dy[2]
    if i == 'U' and ans[0] > 1:
        ans[0] += dx[3]
        ans[1] += dy[3]

print(ans)
