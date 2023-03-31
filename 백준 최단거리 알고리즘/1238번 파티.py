import heapq
import sys
INF = 1e9
input = sys.stdin.readline

def dijkstra(start, distance):
    q = []
    distance[start] = 0
    heapq.heappush(q, (0, start))
    while q:
        dist, now = heapq.heappop(q)
        if dist > distance[now]:
            continue
        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

N, M, X = map(int, input().split())

graph = [[] for _ in range(N + 1)]
for i in range(M):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

ans = 0
X_distance = [INF] * (N + 1)
dijkstra(X, X_distance)

for i in range(1, N+1):
    distance = [INF] * (N + 1)
    dijkstra(i, distance)
    ans = max(ans, distance[X] + X_distance[i])
print(ans)