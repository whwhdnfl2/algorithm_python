import heapq

N, M, C = map(int, input().split())
INF = int(1e9)

graph = [[] for _ in range(N + 1)]
distance = [INF] * (N + 1)
for _ in range(M):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))


def dijkstra(start):
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


dijkstra(C)
ans = 0
Max = 0
for i in distance:
    if i != INF and i != 0:
        if Max < i:
            Max = i
        ans += 1

print(ans, Max)