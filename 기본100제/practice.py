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
    ans = 0
    count1 = 0
    for i in union:
        count1 += 1
        ans += data[i[0]][i[1]]
    ans //= count1
    for i in union:
        data[i[0]][i[1]] = ans



dfs(data, data1, 0, 0)
print(data)
print(data1)
