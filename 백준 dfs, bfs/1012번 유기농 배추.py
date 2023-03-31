from collections import deque

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

def bfs(land, x, y):
    queue = deque()
    queue.append((x, y))
    visited[x][y] = 1
    while queue:
        nx, ny = queue.popleft()
        for i in range(4):
            n_x = nx + dx[i]
            n_y = ny + dy[i]
            if 0 <= n_x < N and 0 <= n_y < M:
                if visited[n_x][n_y] == 0 and land[n_x][n_y] == 1:
                    visited[n_x][n_y] = 1
                    queue.append((n_x, n_y))

T = int(input())

for _ in range(T):
    M, N, K= map(int, input().split())

    land = [[0] * M for _ in range(N)]
    visited = [[0] * M for _ in range(N)]
    for i in range(K):
        x, y = map(int, input().split())
        land[y][x] = 1
    ans = 0
    for i in range(N):
        for j in range(M):
            if land[i][j] == 0 or visited[i][j] == 1:
                continue
            else:
                bfs(land, i, j)
                ans += 1
    print(ans)
    
