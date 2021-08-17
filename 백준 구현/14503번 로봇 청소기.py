N, M = map(int, input().split())

r, c, d = map(int, input().split())

mmap = []

for i in range(N):
    mmap.append(list(map(int, input().split())))

ans = 1
count = 0
mmap[r][c] = 2
while True:
    while True:
        #print(r, c)
        #print(d)
        #print(ans)
        if d == 0:
            if mmap[r][c - 1] == 0:
                c = c - 1
                d = 3
                mmap[r][c] = 2
                ans += 1
                count = 0
            else:
                d = 3
                count += 1
        elif d == 1:
            if mmap[r - 1][c] == 0:
                r = r - 1
                d = 0
                mmap[r][c] = 2
                ans += 1
                count = 0
            else:
                d = 0
                count += 1
        elif d == 2:
            if mmap[r][c + 1] == 0:
                c = c + 1
                d = 1
                mmap[r][c] = 2
                ans += 1
                count = 0
            else:
                d = 1
                count += 1
        elif d == 3:
            if mmap[r + 1][c] == 0:
                r = r + 1
                d = 2
                mmap[r][c] = 2
                ans += 1
                count = 0
            else:
                d = 2
                count += 1
        if count == 4:
            count = 0
            break
    if d == 0 and mmap[r + 1][c] != 1:
        r = r + 1
    elif d == 1 and mmap[r][c - 1] != 1:
        c = c - 1
    elif d == 2 and mmap[r - 1][c] != 1:
        r = r - 1
    elif d == 3 and mmap[r][c + 1] != 1:
        c = c + 1
    else:
        break

print(ans)
