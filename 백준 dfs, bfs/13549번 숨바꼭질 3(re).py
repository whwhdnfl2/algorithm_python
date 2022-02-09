#틀렸는데 0-1bfs 써야한다고 함.
#https://www.acmicpc.net/board/view/73660 참고하기

from collections import deque

N, M = map(int, input().split())
visited = [-1] * 100001

visited[N] = 0
queue = deque()
queue.append(N)

dx = [1, -1, 2]


while queue:
    n = queue.popleft()
    if n == M:
        print(visited[n])
    for i in dx:
        if i == 2:
            if 0 <= n * i < 100001:
                if visited[n*i] == -1:
                    visited[n * i] = visited[n]
                    queue.appendleft(n * i)
        else:
            new_n = n + i
            if 0 <= new_n < 100001:
                if visited[new_n] == -1:
                    visited[new_n] = visited[n] + 1
                    queue.append(n + i)
