from collections import deque

graph = [
    [],
    [2, 3, 8],
    [1, 7],
    [1, 4, 5],
    [3, 5],
    [3, 4],
    [7],
    [2, 6, 8],
    [1, 7]
]
visited = [False] * 9

def dfs(graph, v, visited):
    visited[v] = True
    for i in graph[v]:
        if visited[i] == False:
            dfs(graph, visited[i], visited)

def bfs(graph, start, visited):
    queue = deque()
    queue.append(start)
    visited[start] = True
    while queue:
        v = queue.popleft()
        for i in graph[v]:
            queue.append(i)
            visited[i] = True


dfs(graph, 1, visited)
print()
visited = [False] * 9
bfs(graph, 1, visited)
