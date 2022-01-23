from collections import deque

N, M, K, X = map(int, input().split())
Map = [[] for _ in range(N+1)]
for i in range(M):
    x, y = map(int, input().split())
    Map[x].append(y)
distance = [-1] * (N + 1)


#print(Map)
def bfs(Map, X):
    queue = deque()
    distance[X] = 0
    queue.append(X)
    while queue:
        now = queue.popleft()
        for i in Map[now]:
            if distance[i] == -1:
                queue.append(i)
                distance[i] = distance[now] + 1

bfs(Map, X)
#print(distance)
check = False
for i in range(len(distance)):
    if distance[i] == K:
        print(i)
        check = True

if not check:
    print(-1)

