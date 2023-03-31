N = int(input())

array = list(map(str, input().split()))

a, b = 0, 0

x = [0, 0, 1, -1]
y = [1, -1, 0, 0]
move = ["R", "L", "D", "U"]


for i in array:
    for j in range(4):
        if i == move[j]:
            temp_a = a + x[j]
            temp_b = b + y[j]
    if temp_a < 0 or temp_a > N -1 or temp_b < 0 or temp_b > N - 1:
        continue
    a = temp_a
    b = temp_b
print(a + 1, b + 1)

