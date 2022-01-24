data = [0] * 30001
data[1] = 0
data[2] = 1
data[3] = 1
data[4] = 2
data[5] = 1

X = int(input())

for i in range(6, X + 1):
    ans1 = 9999999
    ans2 = 9999999
    ans3 = 9999999
    ans4 = 9999999
    if i % 5 == 0:
        ans1 = data[i // 5] + 1
    if i % 3 == 0:
        ans2 = data[i // 3] + 1
    if i % 2 == 0:
        ans3 = data[i // 2] + 1
    ans4 = data[i - 1] + 1
    data[i] = min(ans1, ans2, ans3, ans4)

print(data[X])
