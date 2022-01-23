import sys

sys.setrecursionlimit(10**6)

N, L, R = map(int, input().split())
data = []
for i in range(N):
    data.append(list(map(int, input().split())))
data1 = [[0]*N for i in range(N)]
flag = True
union = []
def dfs(data, data1, x, y):
    if data1[x][y] == 1:
        return
    union.append([x, y])
    data1[x][y] = 1
    if x-1 >= 0 and L <= abs(data[x][y] - data[x-1][y]) <= R and data1[x-1][y] == 0:
        dfs(data, data1, x-1, y)
    if x+1 < N and L <= abs(data[x][y] - data[x+1][y]) <= R and data1[x+1][y] == 0:
        dfs(data, data1, x+1, y)
    if y-1 >= 0 and L <= abs(data[x][y] - data[x][y-1]) <= R and data1[x][y-1] == 0:
        dfs(data, data1, x, y-1)
    if y+1 < N and L <= abs(data[x][y] - data[x][y+1]) <= R and data1[x][y+1] == 0:
        dfs(data, data1, x, y+1)

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]
def dfs2(data, data1, x, y):
    if data1[x][y] == 1:
        return
    union.append([x, y])
    data1[x][y] = 1
    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]
        if 0 <= nx < N and 0 <= ny < N: #and not data1[nx][ny]:
            if L <= abs(data[x][y] - data[nx][ny]) <= R:
                #union.append([nx, ny])
                dfs2(data, data1, nx, ny)


ans = 0
while True:
    flag = False
    data1 = [[0] * N for i in range(N)]
    dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]
    for i in range(N):
        for j in range(N):
            #union.append([i, j])
            if data1[i][j] != 1:
                #print(i, j)
                dfs(data, data1, i, j)

                if len(union) > 1:
                    flag = True
                    sum = 0
                    for k in union:
                        sum += data[k[0]][k[1]]
                    sum = sum // len(union)
                    for k in union:
                        data[k[0]][k[1]] = sum
            #print(union)
            union = []
    #print(data)
    if not flag:
        break
    ans += 1
print(ans)
