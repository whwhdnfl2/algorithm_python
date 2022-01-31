import sys
sys.setrecursionlimit(10**6)

N, M = map(int, input().split())

graph = [[] for i in range(N + 1)]
for _ in range(M):
    a = sys.stdin.readline()
    x, y = a.split()
    x = int(x)
    y = int(y)
    graph[x].append(y)
    graph[y].append(x)
visited = [0] * (N + 1)


def dfs(a):
    if visited[a] == 1:
        return
    visited[a] = 1
    for i in graph[a]:
        dfs(i)


count = 0
for i in range(1, (N + 1)):
    if visited[i] == 0:
        count += 1
        dfs(i)
print(count)
