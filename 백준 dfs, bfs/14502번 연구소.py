from collections import deque
from itertools import combinations
import copy

N, M = map(int, input().split())

graph = []
for i in range(N):
    graph.append(list(map(int, input().split())))

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def bfs(insetedgraph, a, b):
    queue = deque()
    queue.append([a, b])
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M:
                if insetedgraph[nx][ny] == 0:
                    queue.append([nx, ny])
                    temp_graph[nx][ny] = 2

data = []
for i in range(N):
    for j in range(M):
        if graph[i][j] == 0:
            data.append([i, j])
result = list(combinations(data, 3))



ans = 0
for i in result:
    temp_ans = 0
    temp_graph = copy.deepcopy(graph)
    for j in i:
        temp_graph[j[0]][j[1]] = 1
    for j in range(N):
        for k in range(M):
            if temp_graph[j][k] == 2:
                bfs(temp_graph, j, k)
    for j in range(N):
        for k in range(M):
            if temp_graph[j][k] == 0:
                temp_ans += 1
    if temp_ans > ans:
        ans = temp_ans
print(ans)
