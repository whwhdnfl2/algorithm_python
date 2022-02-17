from copy import deepcopy
import sys

R, C, T = map(int, input().split())

data = []
for _ in range(R):
    a = sys.stdin.readline()
    data.append(list(map(int, a.split())))
up = []
down = []
flag = False
for i in range(R):
    for j in range(C):
        if data[i][j] == -1:
            up = [i, j]
            down = [i + 1, j]
            flag = True
            break
    if flag:
        break

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def diffusion(a, b, temp2):
    now = temp2[a][b]
    for i in range(4):
        nx = a + dx[i]
        ny = b + dy[i]
        if 0 <= nx < R and 0 <= ny < C:
            if data[nx][ny] != -1:
                data[nx][ny] += now // 5
                data[a][b] -= now // 5


def real():
    temp = deepcopy(data)
    for i in range(R):
        for j in range(C):
            if data[i][j] != -1:
                diffusion(i, j, temp)
    temp = deepcopy(data)
    data[up[0]][1] = 0
    for i in range(2, C):
        data[up[0]][i] = temp[up[0]][i - 1]
    for i in range(up[0] - 1, -1, -1):
        data[i][C - 1] = temp[i + 1][C - 1]
    for i in range(C - 1, 0, -1):
        data[0][i - 1] = temp[0][i]
    for i in range(1, up[0]):
        data[i][0] = temp[i - 1][0]

    data[down[0]][1] = 0
    for i in range(2, C):
        data[down[0]][i] = temp[down[0]][i - 1]
    for i in range(down[0] + 1, R):
        data[i][C - 1] = temp[i - 1][C - 1]
    for i in range(C - 2, -1, -1):
        data[R - 1][i] = temp[R - 1][i + 1]
    for i in range(R - 2, down[0], -1):
        data[i][0] = temp[i + 1][0]

for _ in range(T):
    real()

ans = 0
for i in range(R):
    for j in range(C):
        if data[i][j] != -1:
            ans += data[i][j]
print(ans)