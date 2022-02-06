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
                    real_x = nx
                    real_y = ny
                    while queue:
                        x2, y2 = queue.popleft()
                        for j in range(4):
                            nx2 = x2 + dx[j]
                            ny2 = y2 + dy[j]
                            if 0 <= nx2 < N and 0 <= ny2 < N:
                                if visited[nx2][ny2] == 0 and 0 < data[nx2][ny2] < big:
                                    if visited[x2][y2] < visited[x][y]:
                                        real_x = nx2
                                        real_y = ny2
                                        x = x2
                                        y = y2
                                    elif visited[x2][y2] == visited[x][y]:
                                        if real_x > nx2:
                                            real_y = ny2
                                            real_x = nx2
                                        elif real_x == nx2 and real_y > ny2:
                                            real_x = nx2
                                            real_y = ny2
                    visited[real_x][real_y] = visited[x][y] + 1
                    return [real_x, real_y]
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
    before_x, before_y = shark_x, shark_y
    shark_x, shark_y = bfs(before_x, before_y)
    if shark_x == "g" and shark_y == "g":
        break
    else:
        ans = ans + visited[shark_x][shark_y] - 1
        data[before_x][before_y] = 0
        data[shark_x][shark_y] = 9
        count += 1
        if count == big:
            count = 0
            big += 1

print(ans)
