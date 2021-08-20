N, M = map(int, input().split())

mmap = []

for i in range(N):
    mmap.append(list(map(int, input().split())))

#print(mmap)

count = -1
load1 = []
temp_load = -1

for i in range(N):
    for j in range(N):
        if mmap[i][j] == 2:
            count += 1
            for k1 in range(N):
                for k2 in range(N):
                    if mmap[k1][k2] == 1:
                        temp_load += (abs(k1 - i) + abs(k2 - j))

            load1.append([temp_load, 0, count])
            temp_load = 0

for i in range(N):
    for j in range(N):
        if mmap[i][j] == 1:
            now_load = 99999999999
            index = -1
            last_index = 0
            for k1 in range(N):
                for k2 in range(N):
                    if mmap[k1][k2] == 2:
                        index += 1
                        if (abs(k1 - i) + abs(k2 - j)) < now_load:
                            last_index = index
                            now_load = (abs(k1 - i) + abs(k2 - j))
            load1[last_index][1] += 1
            temp_load = 0
#print(load1)

load1.sort(key=lambda x: x[1], reverse=True)
load1.sort(key=lambda x: x[0])

#print(load1)
for i in range(M):
    count1 = -1
    for j in range(N):
        for k in range(N):
            if mmap[j][k] == 2 or mmap[j][k] == 3:
                count1 += 1
                if count1 == load1[i][2]:
                    mmap[j][k] = 3
#print(mmap)

ans = 0

for i in range(N):
    for j in range(N):
        if mmap[i][j] == 1:
            now_load = 9999999
            index = -1
            last_index = 0
            for k1 in range(N):
                for k2 in range(N):
                    if mmap[k1][k2] == 3:
                        index += 1
                        if (abs(k1 - i) + abs(k2 - j)) < now_load:
                            last_index = index
                            now_load = (abs(k1 - i) + abs(k2 - j))
            ans += now_load
            temp_load = 0

print(ans)
