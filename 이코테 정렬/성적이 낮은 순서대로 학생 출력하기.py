data = []
N = int(input())
for i in range(N):
    input_data = input().split()
    data.append((input_data[0], int(input_data[1])))

data.sort(key=lambda x: x[1])
print(data)