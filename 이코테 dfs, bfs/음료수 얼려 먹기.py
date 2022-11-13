from collections import deque

n, m = map(int, input().split())

graph = []
for i in range(n):
    graph.append(list(map(int, input())))

dx = [0, 0, 1, -1] #동서남북
dy = [1, -1, 0, 0]

def bfs(graph, a, b):
    queue = deque()
    queue.append([a, b])
    graph[a][b] = 1
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            temp_x = x + dx[i]
            temp_y = y + dy[i]
            if 0 <= temp_x < n and 0 <= temp_y < m:
                if graph[temp_x][temp_y] == 0:
                    graph[temp_x][temp_y] = 1
                    queue.append([temp_x, temp_y])

ans = 0
for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            bfs(graph, i, j)
            ans += 1
print(ans)



