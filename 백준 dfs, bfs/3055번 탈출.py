from collections import deque

N, M = map(int, input().split())

titub = [[] * M for i in range(N)]
for i in range(N):
    a = input()
    for j in a:
        titub[i].append(j)

visited = [[0] * M for i in range(N)]

star = []
D_x = 0
D_y = 0
for i in range(N):
    for j in range(M):
        if titub[i][j] == '*':
            star_x = i
            star_y = j
            star.append([star_x, star_y])
        if titub[i][j] == 'S':
            S_x = i
            S_y = j
            visited[i][j] = 1


dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def bfs(star, Sx, Sy):
    queue = deque()
    for e in star:
        visited[e[0]][e[1]] = '*'
        queue.append([e[0], e[1]])
    queue.append([Sx, Sy])
    visited[Sx][Sy] = 1
    while queue:
        x, y = queue.popleft()
        #print(x, y)
        if visited[x][y] != '*':
            count = visited[x][y] + 1
            for j in range(4):
                nx = x + dx[j]
                ny = y + dy[j]
                if 0 <= nx < N and 0 <= ny < M:
                    if titub[nx][ny] == 'D':
                        print(count - 1)
                        return
                    if titub[nx][ny] != 'X' and visited[nx][ny] == 0:
                        visited[nx][ny] = count
                        queue.append([nx, ny])
        elif visited[x][y] == '*':
            for k in range(4):
                nx = x + dx[k]
                ny = y + dy[k]
                if 0 <= nx < N and 0 <= ny < M:
                    if titub[nx][ny] != 'X' and titub[nx][ny] != 'D' and visited[nx][ny] != '*' and visited[nx][ny] == 0:
                        visited[nx][ny] = '*'
                        queue.append([nx, ny])
    print("KAKTUS")



bfs(star, S_x, S_y)
