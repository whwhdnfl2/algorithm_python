N = int(input())

array = []
order = [1] * N

for _ in range(N):
    array.append(list(map(int, input().split())))

for i in range(N):
    for j in range(N):
        if array[i][0] < array[j][0] and array[i][1] < array[j][1]:
            order[i] += 1

for i in order:
    print(i, end=' ')