from collections import deque

N = int(input())
apart = []
for i in range(N):
    data = input()
    data1 = []
    for j in data:
        data1.append(int(j))
    apart.append(data1)

visited = [[0] * N for i in range(N)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def bfs(a, b, count1):
    queue = deque()
    queue.append([a, b])
    visited[a][b] = count1
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N:
                if visited[nx][ny] == 0 and apart[nx][ny] == 1:
                    queue.append([nx, ny])
                    visited[nx][ny] = count1


count = 0
for i in range(N):
    for j in range(N):
        if apart[i][j] == 0:
            continue
        if visited[i][j] != 0:
            continue
        count += 1
        bfs(i, j, count)

ans = [0] * (count + 1)
for i in range(1, count + 1):
    for j in range(N):
        for k in range(N):
            if visited[j][k] == i:
                ans[i] += 1
ans.sort()
print(len(ans) - 1)
for i in ans:
    if i != 0:
        print(i)
