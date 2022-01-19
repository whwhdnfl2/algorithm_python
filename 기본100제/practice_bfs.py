from collections import deque

def bfs(graph, v, visited):
    queue = deque()
    visited[v] = True
    queue.append(v)

    while queue:
        now = queue.popleft()
        print(now)
        for i in graph[now]:
            if not visited[i]:
                visited[i] = True
                queue.append(i)

visited = [False] * 9
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

bfs(graph, 1, visited)