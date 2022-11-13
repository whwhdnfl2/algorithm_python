N = int(input())

array = list(map(int, input().split()))
ans = [0] * N

ans[0] = array[0]
if array[1] > ans[0]:
    ans[1] = array[1]
else:
    ans[1] = array[0]

for i in range(2, N):
    if ans[i-1] < ans[i-2] + array[i]:
        ans[i] = ans[i-2] + array[i]
    else:
        ans[i] = ans[i-1]
print(ans[N-1])