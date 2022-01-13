import math

n, m = map(int, input().split())

ans = 0

for i in range(n):
    array = list(map(int, input().split()))
    if min(array) > ans:
        ans = min(array)
print(ans)
