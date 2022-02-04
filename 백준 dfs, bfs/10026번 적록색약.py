import sys
from collections import deque

N = int(input())
data = []
for i in range(N):
    temp = []
    a = sys.stdin.readline()
    for j in a:
        if j == '\n':
            continue
        temp.append(j)
    data.append(temp)

visited1 = [[0] * N for _ in range(N)]
visited2 = [[0] * N for _ in range(N)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def bfs1(a, b):
    queue = deque()
    visited1[a][b] = 1
    queue.append([a, b])
    while queue:
        x, y = queue.popleft()
        if data[x][y] == 'R':
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0 <= nx < N and 0 <= ny < N:
                    if visited1[nx][ny] == 0 and data[nx][ny] == 'R':
                        visited1[nx][ny] = 1
                        queue.append([nx, ny])
        if data[x][y] == 'G':
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0 <= nx < N and 0 <= ny < N:
                    if visited1[nx][ny] == 0 and data[nx][ny] == 'G':
                        visited1[nx][ny] = 1
                        queue.append([nx, ny])
        if data[x][y] == 'B':
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0 <= nx < N and 0 <= ny < N:
                    if visited1[nx][ny] == 0 and data[nx][ny] == 'B':
                        visited1[nx][ny] = 1
                        queue.append([nx, ny])


def bfs2(a, b):
    queue = deque()
    visited2[a][b] = 1
    queue.append([a, b])
    while queue:
        x, y = queue.popleft()
        if data[x][y] == 'R' or data[x][y] == 'G':
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0 <= nx < N and 0 <= ny < N:
                    if visited2[nx][ny] == 0:
                        if data[nx][ny] == 'R' or data[nx][ny] == 'G':
                            visited2[nx][ny] = 1
                            queue.append([nx, ny])
        if data[x][y] == 'B':
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0 <= nx < N and 0 <= ny < N:
                    if visited2[nx][ny] == 0 and data[nx][ny] == 'B':
                        visited2[nx][ny] = 1
                        queue.append([nx, ny])


count1 = 0
for i in range(N):
    for j in range(N):
        if visited1[i][j] == 0:
            bfs1(i, j)
            count1 += 1

count2 = 0
for i in range(N):
    for j in range(N):
        if visited2[i][j] == 0:
            bfs2(i, j)
            count2 += 1

print(count1, count2)
