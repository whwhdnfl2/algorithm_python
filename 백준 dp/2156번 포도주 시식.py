import sys

N = int(input())
data = [0]
for i in range(N):
    data.append(int(sys.stdin.readline()))

print(data)
ans = [0] * 10001
ans[1] = data[1]
ans[2] = data[1] + data[2]
