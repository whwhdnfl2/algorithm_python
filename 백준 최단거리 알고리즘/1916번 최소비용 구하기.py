import heapq
import sys
input = sys.stdin.readline

INF = int(1e9)

N = int(input())
M = int(input())

graph = [[] for i in range(N + 1)]
for i in range(M):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

distance = [1e9] * (N + 1)

start, finish = map(int, input().split())


def dijkstra(start):
    queue = []
    heapq.heappush(queue, (start, 0))
    distance[start] = 0
    while queue:
        now, dist = heapq.heappop(queue)
        if distance[now] < dist:
            continue
        for i in graph[now]:
            cost = dist + i[1]
            if distance[i[0]] > cost:
                distance[i[0]] = cost
                heapq.heappush(queue, (i[0], cost))


dijkstra(start)

print(distance[finish])