from collections import deque

queue = deque()
N, M = map(int, input().split())
graph = []
for i in range(N):
    graph.append(list(map(int, input())))


def bfs2(i, j):
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


def bfs(i, j):
    queue2 = deque()
    queue2.append([i, j])
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    #print(queue)
    graph[i][j] = 1
    while queue2:
        print(queue2)
        x, y = queue2.popleft()
        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]
            if nx < 0 or nx > N - 1 or ny < 0 or ny > M - 1:
                continue
            if graph[nx][ny] == 0:
                continue
            if graph[nx][ny] == 1:
                graph[nx][ny] = graph[x][y] + 1
                queue2.append([nx, ny])
    return graph[N-1][M-1]


print(bfs(0, 0))
