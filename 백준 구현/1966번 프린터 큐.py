from collections import deque


def printer():
    N, M = map(int, input().split())
    data = list(map(int, input().split()))
    queue = deque()
    for i in range(N):
        data1 = [i, data[i]]
        queue.append(data1)
    count = 0
    while queue:
        flag = True
        a, b = queue.popleft()
        if len(queue) != 0:
            for i in queue:
                if i[1] > b:
                    flag = False
                    continue
        else:
            count += 1
            if M == a:
                print(count)
                break
        if not flag:
            queue.append([a, b])
        if flag:
            count += 1
            if M == a:
                print(count)
                break


X = int(input())
for i in range(X):
    printer()
