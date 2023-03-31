import sys
from collections import deque

N = int(input())
data = []
for i in range(N):
    a = sys.stdin.readline()
    data.append(list(map(int, a.split())))

max_height = 0
for i in range(N):
    for j in range(N):
        if data[i][j] > max_height:
            max_height = data[i][j]

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def bfs(j, k):
    queue = deque()
    visited[j][k] = 1
    queue.append([j, k])
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N:
                if visited[nx][ny] == 0:
                    visited[nx][ny] = 1
                    queue.append([nx, ny])


count = 0
for i in range(max_height):
    temp = 0
    visited = [[0] * N for _ in range(N)]
    for j in range(N):
        for k in range(N):
            if data[j][k] <= i:
                visited[j][k] = -1
    for j in range(N):
        for k in range(N):
            if visited[j][k] == 0:
                bfs(j, k)
                temp += 1

    if temp > count:
        count = temp
print(count)
