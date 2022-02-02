data = [0] * 1000001
data[1] = 1
data[2] = 2
data[3] = 3

N = int(input())
for i in range(4, N + 1):
    data[i] = (data[i-1] + data[i-2]) % 15746
print(data[N])
