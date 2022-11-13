#다익스트라
import heapq
import sys

input = sys.stdin.readline

INF = int(1e9)
n, m = map(int, input().split())#노드의 개수, 간선의 개수

graph = [[] for i in range(n + 1)]

distance = [INF] * (n + 1)

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

def dijkstra(start):
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


#플로이드 워서
n, m = map(int, input().split()) #노드의 개수, 간선의 개수

graph = [[INF] * (n + 1) for _ in range(n + 1)]

for i in range(1, n + 1):
    for j in range(1, n + 1):
        if i == j:
            graph[i][j] = 0

for _ in range(m):
    a, b, c = map(int, input().split()) #a에서 b노드로 가는 거리: c
    graph[a][b] = c

for k in range(n + 1):
    for i in range(n + 1):
        for j in range(n + 1):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])
