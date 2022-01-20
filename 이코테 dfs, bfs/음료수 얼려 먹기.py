N, M = map(int, input().split())

MAP = []
for i in range(N):
    MAP.append(list(map(int, input())))

def dfs(MAP, i, j):
    if i <= -1 or j <= -1 or i >= N or j >= M:
        return False
    if MAP[i][j] == 0:
        MAP[i][j] = 1
        dfs(MAP, i - 1, j)
        dfs(MAP, i, j - 1)
        dfs(MAP, i + 1, j)
        dfs(MAP, i, j + 1)
        return True
    return False
ans = 0
for i in range(N):
    for j in range(M):
        if dfs(MAP, i, j):
            ans += 1
print(ans)