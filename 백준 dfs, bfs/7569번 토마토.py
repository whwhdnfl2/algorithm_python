from collections import deque
import sys

M, N, H = map(int, input().split())
data = [[] for j in range(H)]
visited = [[[0] * M for _ in range(N)] for _ in range(H)]


for i in range(H):
    for j in range(N):
        a = sys.stdin.readline()
        data[i].append(list(map(int, a.split())))


one = []
for i in range(H):
    for j in range(N):
        for k in range(M):
            if data[i][j][k] == 1:
                one.append([k, j, i])

dx = [1, -1, 0, 0, 0, 0]
dy = [0, 0, 1, -1, 0, 0]
dz = [0, 0, 0, 0, 1, -1]


def bfs(one):
    queue = deque()
    for w in one:
        a, b, c = w
        queue.append(w)
        visited[c][b][a] = 1
    while queue:
        x, y, z = queue.popleft()
        for i in range(6):
            nx = x + dx[i]
            ny = y + dy[i]
            nz = z + dz[i]
            if 0 <= nx < M and 0 <= ny < N and 0 <= nz < H:
                if data[nz][ny][nx] == 0 and visited[nz][ny][nx] == 0:
                    queue.append([nx, ny, nz])
                    visited[nz][ny][nx] = visited[z][y][x] + 1


bfs(one)


flag = True
ans = 0
for i in range(H):
    if not flag:
        break
    for j in range(N):
        if not flag:
            break
        for k in range(M):
            if data[i][j][k] == 0 and visited[i][j][k] == 0:
                print(-1)
                flag = False
                break
            if visited[i][j][k] > ans:
                ans = visited[i][j][k]

if flag:
    print(ans - 1)