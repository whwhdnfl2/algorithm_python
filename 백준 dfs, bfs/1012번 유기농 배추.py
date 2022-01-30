from collections import deque

T = int(input())

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def bfs():
    m, n, k = map(int, input().split())
    MAP = [[0] * m for _ in range(n)]
    visited = [[0] * m for _ in range(n)]
    for i in range(k):
        y, x = map(int, input().split())
        MAP[x][y] = 1
    count = 0
    for i in range(n):
        for j in range(m):
            if visited[i][j] == 1:
                continue
            if MAP[i][j] == 0:
                continue
            count += 1
            queue = deque()
            queue.append([i, j])
            visited[i][j] = 1
            while queue:
                x, y = queue.popleft()
                for k in range(4):
                    nx = x + dx[k]
                    ny = y + dy[k]
                    if 0 <= nx < n and 0 <= ny < m:
                        if visited[nx][ny] == 0 and MAP[nx][ny] == 1:
                            queue.append([nx, ny])
                            visited[nx][ny] = 1
    print(count)


for i in range(T):
    bfs()
