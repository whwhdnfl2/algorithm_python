N = int(input())
M = int(input())
graph = [[] for _ in range(N + 1)]
for i in range(M):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)
visited = [0] * (N + 1)

def dfs(a):
    if visited[a] == 1:
        return
    visited[a] = 1
    for i in graph[a]:
        if visited[a] == 1:
            dfs(i)

dfs(1)
#print(visited)
count = 0
for i in visited:
    if i == 1:
        count += 1
print(count - 1)

#양방향인지 단방향인지 확인하자