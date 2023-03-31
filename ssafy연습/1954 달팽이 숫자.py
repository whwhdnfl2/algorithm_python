from collections import deque


dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

N = int(input())

def snailNum(snail, num):
    insert = 1
    x = 0
    y = 0
    upflag = False
    snail[x][y] = insert
    while num**2 != insert:
        insert += 1
        for i in range(4):
            if i == 3:
                upflag = True
                break
            temp_x = x + dx[i]
            temp_y = y + dy[i]
            if temp_x < num and temp_y < num:
                if snail[temp_x][temp_y] == 0:
                    snail[temp_x][temp_y] = insert
                    x = temp_x
                    y = temp_y
                    break
        if upflag:
            while snail[x - 1][y] == 0:
                x -= 1
                snail[x][y] = insert
                insert += 1
            upflag = False
            insert -= 1


for k in range(N):
    num = int(input())
    snail = [[0] * num for _ in range(num)]
    snailNum(snail, num)
    print("#" + str(k + 1), end='')
    for i in range(num):
        print()
        for j in range(num):
            print(snail[i][j], end=' ')