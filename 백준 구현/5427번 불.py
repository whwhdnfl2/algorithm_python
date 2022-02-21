import sys
from collections import deque

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def bfs():
    M, N = map(int, input().split())
    data = []
    for _ in range(N):
        a = sys.stdin.readline()
        temp = []
        for i in a:
            if i != '\n':
                temp.append(i)
        data.append(temp)

    visited = [[0] * M for _ in range(N)]
    if M == 1 and N == 1:
        print(1)
        return

    queue = deque()
    for i in range(N):
        for j in range(M):
            if data[i][j] == '*':
                queue.append([i, j])
                visited[i][j] = -1
    for i in range(N):
        for j in range(M):
            if data[i][j] == '@':
                queue.append([i, j])
                visited[i][j] = 1
    flag = False
    while queue:
        x, y = queue.popleft()
        if x == 0 or x == N - 1 or y == 0 or y == M - 1:
            if data[x][y] == "@":
                print(visited[x][y])
                flag = True
                break
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if visited[x][y] >= 0:
                if 0 <= nx < N and 0 <= ny < M:
                    if data[nx][ny] == '.' and visited[nx][ny] == 0:
                        visited[nx][ny] = visited[x][y] + 1
                        data[nx][ny] = '@'
                        queue.append([nx, ny])
            if visited[x][y] == -1:
                if 0 <= nx < N and 0 <= ny < M:
                    if data[nx][ny] == '.' and visited[nx][ny] == 0:
                        visited[nx][ny] = -1
                        data[nx][ny] = "*"
                        queue.append([nx, ny])
    if not flag:
        print("IMPOSSIBLE")


T = int(input())
for _ in range(T):
    bfs()
