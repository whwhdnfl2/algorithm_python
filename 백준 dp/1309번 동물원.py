N = int(input())

no_data = [0] * 100001
left_data = [0] * 100001
right_data = [0] * 100001
no_data[0] = 1

for i in range(1, N + 1):
    no_data[i] = (left_data[i - 1] + right_data[i - 1] + no_data[i - 1]) % 9901
    left_data[i] = (right_data[i - 1] + no_data[i - 1]) % 9901
    right_data[i] = (left_data[i - 1] + no_data[i - 1]) % 9901

print((no_data[N] + left_data[N] + right_data[N]) % 9901)
