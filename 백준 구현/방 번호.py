N = input()

data = [0] * 10

for i in N:
    data[int(i)] += 1

ans = 0
temp = 0
for i in range(len(data)):
    if i == 6 or i == 9:
        temp += data[i]
    else:
        if data[i] > ans:
            ans = data[i]
temp2 = 0
if temp % 2 == 1:
    temp2 = temp // 2 + 1
else:
    temp2 = temp // 2

if temp2 > ans:
    ans = temp2
print(ans)