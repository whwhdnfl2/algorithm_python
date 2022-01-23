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
    data1[x][y] = 1
    union.append([x, y])
    if x-1 > 0 and L <= abs(data[x][y] - data[x-1][y]) <= R:
        dfs(data, data1, x-1, y)
    if x+1 < N and L <= abs(data[x][y] - data[x+1][y]) <= R:
        dfs(data, data1, x+1, y)
    if y-1 > 0 and L <= abs(data[x][y] - data[x][y-1]) <= R:
        dfs(data, data1, x, y-1)
    if y+1 < N and L <= abs(data[x][y] - data[x][y+1]) <= R:
        dfs(data, data1, x, y+1)

count = 0
while flag:
    flag = False
    count += 1
    data1 = [[0] * N for i in range(N)]
    for i in range(N):
        for j in range(N):
            if data1[i][j] == 1:
                continue
            dfs(data, data1, i, j)
            if len(union) > 1:
                flag = True
                ans = 0
                count1 = 0
                for k in union:
                    count1 += 1
                    ans += data[k[0]][k[1]]
                ans //= count1
                for k in union:
                    data[k[0]][k[1]] = ans
            union = []

print(count - 1)
