N = int(input())

a = []

for i in range(N):
    a.append(list(map(int, input().split())))

a.sort(key=lambda x: x[0])
a.sort(key=lambda x: x[1])

last = -1
count = 0

for i in a:
    if i[0] < last:
        continue

    else:
        last = i[1]
        count += 1

print(count)
