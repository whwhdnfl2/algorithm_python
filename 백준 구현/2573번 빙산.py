from collections import deque
import copy
N, M = map(int, input().split())
data = []
for _ in range(N):
    data.append(list(map(int, input().split())))

not_one = []
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
visited = [[0] * M for _ in range(N)]
for i in range(N):
    for j in range(M):
        if data[i][j] != 0:
            not_one.append([i, j])


def bfs(a, b):
    queue = deque()
    queue.append([a, b])
    visited[a][b] = 1
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M:
                if data[nx][ny] != 0 and visited[nx][ny] == 0:
                    visited[nx][ny] = 1
                    queue.append([nx, ny])


ans = 0
temp_data = copy.deepcopy(data)
while True:
    for i in not_one:
        for j in range(4):
            nx = i[0] + dx[j]
            ny = i[1] + dy[j]
            if 0 <= nx < N and 0 <= ny < M:
                if temp_data[nx][ny] == 0:
                    if data[i[0]][i[1]] > 0:
                        data[i[0]][i[1]] -= 1
    temp_data = copy.deepcopy(data)
    count = 0
    flag = False
    visited = [[0] * M for _ in range(N)]
    for i in not_one:
        if data[i[0]][i[1]] != 0 and visited[i[0]][i[1]] == 0:
            flag = True
            bfs(i[0], i[1])
            count += 1
    if not flag:
        ans = 0
        break
    ans += 1
    if count > 1:
        break

print(ans)
