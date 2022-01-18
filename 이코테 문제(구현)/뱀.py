from collections import deque

N = int(input())
MAP = [[0] * N for _ in range(N)]
MAP[0][0] = 2
K = int(input())
for i in range(K):
    x, y = map(int, input().split())
    MAP[x - 1][y - 1] = 1

x, y = 0, 0
direction = 1#동남서북
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

L = int(input())
direction_info = []
for i in range(L):
    A, B = input().split()
    A = int(A)
    direction_info.append((A, B))

#print(direction_info)
now = deque()
now.append([x, y])

count = 0

while True:
    count += 1
    x = x + dx[direction - 1]
    y = y + dy[direction - 1]
    if x == N or y == N or x < 0 or y < 0:
        #print(1)
        break
    if MAP[x][y] == 2:
        #print(2)
        break

    if MAP[x][y] == 1:
        MAP[x][y] = 2
        now.appendleft([x, y])
    elif MAP[x][y] == 0:
        MAP[x][y] = 2
        now.appendleft([x, y])
        ax, ay = now.pop()
        MAP[ax][ay] = 0
    #print(now)
    for i in direction_info:
        if i[0] == count:
            if direction == 1:
                if i[1] == 'D':
                    direction = 2
                else:
                    direction = 4
            elif direction == 2:
                if i[1] == 'D':
                    direction = 3
                else:
                    direction = 1
            elif direction == 3:
                if i[1] == 'D':
                    direction = 4
                else:
                    direction = 2
            elif direction == 4:
                if i[1] == 'D':
                    direction = 1
                else:
                    direction = 3
    #for a,b,c,d,e,f,g,h,i,j in MAP:
     #   print(a,b,c,d,e,f,g,h,i,j)
    #print(now)
    #print()
print(count)

