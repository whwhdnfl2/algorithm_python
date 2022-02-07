import sys
from collections import deque

N, M = map(int, input().split())
data = []

for i in range(N):
    a = sys.stdin.readline()
    temp = []
    for j in a:
        if j != '\n':
            temp.append(int(j))
    data.append(temp)


dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def bfs():
    queue = deque()
    visited = [[[0] * 2 for _ in range(M)] for _ in range(N)]
    queue.append([0, 0, 0])
    visited[0][0][0] = 1
    while queue:
        x, y, c = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M:
                if nx == N - 1 and ny == M - 1:
                    return visited[x][y][c] + 1
                if data[nx][ny] == 1 and c == 0 and visited[nx][ny][c] == 0:
                    visited[nx][ny][1] = visited[x][y][c] + 1
                    queue.append([nx, ny, 1])
                elif data[nx][ny] == 0 and visited[nx][ny][c] == 0:
                    visited[nx][ny][c] = visited[x][y][c] + 1
                    queue.append([nx, ny, c])
    return -1


if N == 1 and M == 1:
    print(1)
else:
    print(bfs())
