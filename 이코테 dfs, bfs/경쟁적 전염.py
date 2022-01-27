from collections import deque

N, K = map(int, input().split())
data = []
for i in range(N):
    data.append(list(map(int, input().split())))
S, X, Y = map(int, input().split())

temp = []
for i in range(N):
    for j in range(N):
        if data[i][j] != 0:
            temp.append([data[i][j], i, j])
temp.sort()
queue = deque(temp)
#print(queue)
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

before = 0
after = 0
info = 0
while queue:
    count, x, y = queue.popleft()
    after = data[x][y]
    if before == K and after == 1:
        info += 1
    if info == S:
        break
    before = data[x][y]
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < N and 0 <= ny < N:
            if data[nx][ny] == 0:
                data[nx][ny] = count
                queue.append([data[nx][ny], nx, ny])
    #print(queue)
print(data[X - 1][Y - 1])
