import sys
from collections import deque

data = []
for _ in range(12):
    temp = input()
    temp2 = []
    for i in temp:
        temp2.append(i)
    data.append(temp2)

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def bfs(a, b):
    temp_data = [[0] * 6 for _ in range(12)]
    queue = deque()
    queue.append((a, b))
    temp_data[a][b] = 1
    visited[a][b] = 1
    count = 1
    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < 12 and 0 <= ny < 6:
                if data[a][b] == data[nx][ny] and visited[nx][ny] == 0:
                    count += 1
                    temp_data[nx][ny] = 1
                    queue.append((nx, ny))
                    visited[nx][ny] = 1
    if count >= 4:
        for i in range(12):
            for j in range(6):
                if temp_data[i][j] == 1:
                    data[i][j] = '.'
        return 1
    return 0


flag = 1
ans = -1
while flag:
    ans += 1
    flag = 0
    visited = [[0] * 6 for _ in range(12)]
    for i in range(12):
        for j in range(6):
            if visited[i][j] == 0 and data[i][j] != '.':
                flag += bfs(i, j)
    flag2 = True
    while flag2:
        flag2 = False
        for i in range(11, 0, -1):
            for j in range(6):
                if data[i][j] == '.' and data[i - 1][j] != '.' and i != 1:
                    data[i][j] = data[i - 1][j]
                    data[i - 1][j] = '.'
                    flag2 = True
                elif data[i][j] == '.' and data[i - 1][j] != '.' and i == 1:
                    data[i][j] = data[i - 1][j]
                    data[0][j] = '.'
                    flag2 = True

print(ans)
