from collections import deque
N, K = map(int, input().split())


def bfs(n, k):
    # if n == k:
    #     print(0)
    #     return
    queue = deque()
    visited = [0] * 300001
    queue.append(n)
    visited[n] = 1
    while True:
        #print(queue)
        a = queue.popleft()
        if a == k:
            print(visited[a] - 1)
            return
        #print(a)
        if 0 <= a - 1 < 300001:
            if visited[a - 1] == 0:
                queue.append(a - 1)
                visited[a - 1] = visited[a] + 1
                # if a - 1 == k:
                #     print(visited[a - 1] - 1)
                #     return
        if 0 <= a + 1 < 300001:
            if visited[a + 1] == 0:
                queue.append(a + 1)
                visited[a + 1] = visited[a] + 1
                # if a + 1 == k:
                #     print(visited[a + 1] - 1)
                #     return
        if 0 <= a * 2 < 300001:
            if visited[a * 2] == 0:
                queue.append(a * 2)
                visited[a * 2] = visited[a] + 1
                # if a * 2 == k:
                #     print(visited[a * 2] - 1)
                #     return


bfs(N, K)
