from collections import deque

queue = deque()
N, M = map(int, input().split())
graph = []
for i in range(N):
    graph.append(list(map(int, input())))

def bfs(i, j):
    queue.append([i, j])
    #print(queue)
    graph[i][j] = 1
    while True:
        #print(queue)
        x, y = queue.popleft()
        if x == N-1 and y == M-1:
            return graph[N-1][M-1]
        now = graph[x][y]
        if x - 1 >= 0 and graph[x-1][y] == 1:
            queue.append([x-1, y])
            graph[x-1][y] = now + 1
        if y - 1 >= 0 and graph[x][y-1] == 1:
            queue.append([x, y-1])
            graph[x][y-1] = now + 1
        if x + 1 < N and graph[x+1][y] == 1:
            queue.append([x+1, y])
            graph[x+1][y] = now + 1
        if y + 1 < M and graph[x][y+1] == 1:
            queue.append([x, y+1])
            graph[x][y+1] = now + 1

print(bfs(0, 0))