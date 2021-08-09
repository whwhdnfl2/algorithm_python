n = int(input())

plans = input().split()

dx = [0, -1, 1, 0]
dy = [-1, 0, 0, 1]

move = ['L', 'U', 'D', 'R']

x, y = 1, 1

for plan in plans:
    for i in range(len(move)):
        if move[i] == plan:
            temp_x = x + dx[i]
            temp_y = y + dy[i]
    if temp_x < 1 or temp_x > n or temp_y < 1 or temp_y > n:
        continue
    x = temp_x
    y = temp_y

print(x, y)
