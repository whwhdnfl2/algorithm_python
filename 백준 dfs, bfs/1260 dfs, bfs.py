from collections import deque

N, M, V = map(int, input().split())
graph = [[]for _ in range(N + 1)]
visited = [0] * (N + 1)
for i in range(M):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)
    graph[x].sort()
    graph[y].sort()


def dfs(v):
    if visited[v] == 1:
        return
    visited[v] = 1
    print(v, end=' ')
    for i in graph[v]:
        if visited[i] == 0:
            dfs(i)


dfs(V)
print()
visited = [0] * (N + 1)
queue = deque()


def bfs(v):
    queue.append(v)
    visited[v] = 1
    print(v, end=' ')
    while queue:
        x = queue.popleft()
        for i in graph[x]:
            if visited[i] == 0:
                queue.append(i)
                visited[i] = 1
                print(i, end= ' ')


bfs(V)
