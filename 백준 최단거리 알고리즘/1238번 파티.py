import heapq
import sys
import copy

N, M, X = map(int, input().split())
INF = int(1e9)

graph = [[] for i in range(M + 1)]
for _ in range(M):
    a = sys.stdin.readline()
    b, c, d = map(int, a.split())
    graph[b].append((c, d))


def dijkstra(start):
    distance = [INF] * (N + 1)
    queue = []
    heapq.heappush(queue, (start, 0))
    distance[start] = 0
    while queue:
        now, dist = heapq.heappop(queue)
        if dist > distance[now]:
            continue
        for i in graph[now]:
            cost = i[1] + dist
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(queue, (i[0], cost))
    return distance

ans = [0] * (N + 1)

for i in range(1, N + 1):
    ans[i] += dijkstra(X)[i]
    ans[i] += dijkstra(i)[X]

ans1 = 0
for i in ans:
    if i > ans1:
        ans1 = i
print(ans1)