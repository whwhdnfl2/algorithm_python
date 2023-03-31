from collections import deque

N, M = map(int, input().split())
miro = []
for i in range(N):
    data = input()
    data1 = []
    for j in data:
        data1.append(int(j))
    miro.append(data1)

visited = [[0] * M for i in range(N)]
#print(visited)

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
queue = deque()


def bfs(a, b):
    queue.append([a, b])
    visited[a][b] = 1
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M:
                if visited[nx][ny] == 0 and miro[nx][ny] == 1:
                    queue.append([nx, ny])
                    visited[nx][ny] = visited[x][y] + 1


bfs(0, 0)
print(visited[N - 1][M - 1])
