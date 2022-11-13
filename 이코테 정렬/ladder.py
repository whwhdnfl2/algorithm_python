N = int(input())

dx = [0, 0, 1]
dy = [1, -1, 0]

for _ in range(10):
    ladder = []
    for i in range(100):
        a = list(map(int, input().split()))
        ladder.append(a)

    ans = 0
    flag2 = False
    for i in range(100):
        visited = [[0 for i in range(100)] for _ in range(100)]
        if flag2:
            break
        if ladder[0][i] == 1:
            firsty = i
            x = 1
            y = i
            flag = True
            while flag:
                for j in range(3):
                    temp_x = x + dx[j]
                    temp_y = y + dy[j]
                    if temp_x < 0 or temp_y < 0:
                        continue
                    if temp_y == 100:
                        continue
                    if temp_x == 100:
                        flag = False
                        break
                    if visited[temp_x][temp_y] == 1:
                        continue
                    if ladder[temp_x][temp_y] == 1 or ladder[temp_x][temp_y] == 2:
                        x = temp_x
                        y = temp_y
                        visited[x][y] = 1
                        break
                if ladder[x][y] == 2:
                    ans = firsty
                    flag = False
                    flag2 = True
    print(ans)