N = int(input())

INF = int(1e9)

graph = []
for _ in range(N):
    graph.append(list(map(int, input().split())))

for i in range(N):
    for j in range(N):
        if graph[i][j] == 0:
            graph[i][j] = INF

for k in range(N):
    for i in range(N):
        for j in range(N):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

for i in range(N):
    for j in range(N):
        if graph[i][j] == INF:
            graph[i][j] = 0
        else:
            graph[i][j] = 1

for i in range(N):
    if i != 0:
        print('\n', end='')
    for j in range(N):
        print(graph[i][j], end=' ')