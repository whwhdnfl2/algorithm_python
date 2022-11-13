N = int(input())

array = []
for i in range(100):
    temp_array = list(map(int, input().split()))
    array.append(temp_array)

row = [0] * 100
col = [0] * 100
cross1 = 0
cross2 = 0
for i in range(100):
    for j in range(100):
        row[i] += array[i][j]
        col[j] += array[i][j]
        if i == j:
            cross1 += array[i][j]
        if i + j == 99:
            cross2 += array[i][j]
print(max((max(row), max(col), cross1, cross2)))
