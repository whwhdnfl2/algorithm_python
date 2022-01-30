from collections import deque

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

M, N = map(int, input().split())
tomato = []

for i in range(N):
    tomato.append(list(map(int, input().split())))

visited = [[0] * M for _ in range(N)]
queue = deque()
for i in range(N):
    for j in range(M):
        if tomato[i][j] == 1:
            visited[i][j] = 1
            queue.append([i, j])
while queue:
    x, y = queue.popleft()
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < N and 0 <= ny < M:
            if visited[nx][ny] == 0 and tomato[nx][ny] == 0:
                queue.append([nx, ny])
                visited[nx][ny] = visited[x][y] + 1
                tomato[nx][ny] = 1


ans = 0
flag = False
for i in range(N):
    for j in range(M):
        if tomato[i][j] == 0:
            ans = -1
            flag = True
            break
        if visited[i][j] > ans:
            ans = visited[i][j]
    if flag:
        break
if ans == -1:
    print(-1)
else:
    print(ans - 1)