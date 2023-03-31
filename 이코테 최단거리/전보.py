import heapq

N, M, C = map(int, input().split())
INF = 1e9

distance = [INF] * (N + 1)


graph = [[] for _ in range(N + 1)]
for i in range(M):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

def find(C):
    q = []
    distance[C] = 0
    heapq.heappush(q, (0, C))
    while q:
        dist, now = heapq.heappop(q)
        if dist > distance[now]:
            continue
        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

find(C)

ans = 0
ans_max = 0
for i in distance:
    if i != INF and i != 0:
        ans += 1
        if i > ans_max:
            ans_max = i

print(ans, ans_max)
