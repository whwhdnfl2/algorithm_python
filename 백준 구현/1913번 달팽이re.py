N = int(input())
M = int(input())

snail = [[1] * N for _ in range(N)]
X, Y = 0, 0

def fill(N, snail):
    startX = 0
    startY = 0
    cut = 0
    end = N
    num = N * N
    while True:
        if num == 1:
            break
        elif num == (N -2) * (N - 2):
            startX += 1
            startY += 1
            cut += 1
            end -= 1
            N = N - 2
        else:
            if num == M:
                X, Y = startX + 1, startY + 1
            if startX <= end - 1 and startY == cut:
                snail[startX][startY] = num
                num -= 1
                startX += 1
                if startX == end:
                    startX -= 1
                    startY += 1
            elif startX == end - 1 and cut < startY <= end - 1:
                snail[startX][startY] = num
                num -= 1
                startY += 1
                if startY == end:
                    startY -= 1
                    startX -= 1
            elif cut < startX < end - 1 and startY == end - 1:
                snail[startX][startY] = num
                num -= 1
                startX -= 1
            elif startX == cut and cut < startY <= end - 1:
                snail[startX][startY] = num
                num -= 1
                startY -= 1

fill(N, snail)


if M == 1:
    X, Y = (N // 2) + 1, (N // 2) + 1

for i in range(N):
    if i != 0:
        print()
    for j in range(N):
        if snail[i][j] == M:
            X, Y = i + 1, j + 1
        print(snail[i][j], end=' ')

print()
print(X, Y)