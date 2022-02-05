from collections import deque
import sys

N = int(input())
data = []
visited = [[0] * N for _ in range(N)]
for i in range(N):
    a = sys.stdin.readline()
    data.append(list(map(int, a.split())))

shark_x = 0
shark_y = 0
for i in range(N):
    for j in range(N):
        if data[i][j] == 9:
            shark_x = i
            shark_y = j
big = 2
dx = [-1, 0, 0, 1]
dy = [0, -1, 1, 0]


def bfs(a, b):
    queue = deque()
    visited[a][b] = 1
    queue.append([a, b])
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N:
                if visited[nx][ny] == 0 and 0 < data[nx][ny] < big:
                    data[a][b] = 0
                    data[nx][ny] = 9
                    visited[nx][ny] = visited[x][y] + 1
                    return [nx, ny]
                if visited[nx][ny] == 0 and data[nx][ny] == 0:
                    visited[nx][ny] = visited[x][y] + 1
                    queue.append([nx, ny])
                if visited[nx][ny] == 0 and data[nx][ny] == big:
                    visited[nx][ny] = visited[x][y] + 1
                    queue.append([nx, ny])
    return ["g", "g"]


count = 0
ans = 0
while True:
    visited = [[0] * N for _ in range(N)]
    shark_x, shark_y = bfs(shark_x, shark_y)
    if shark_x == "g" and shark_y == "g":
        break
    else:
        ans = ans + visited[shark_x][shark_y] - 1
        count += 1
        if count == big:
            count = 0
            big += 1
    print(data)
print(ans)