from collections import deque

N, M = map(int, input().split())

miro = []
for i in range(N):
    miro.append(list(map(int, input())))

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def bfs(miro, a, b):
    queue = deque()
    queue.append([a, b])
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M:
                if miro[nx][ny] == 1:
                    miro[nx][ny] = miro[x][y] + 1
                    queue.append([nx, ny])

bfs(miro, 0, 0)
print(miro[N-1][M-1])
print(miro)
