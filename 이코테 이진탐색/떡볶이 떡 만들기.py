from bisect import bisect_left

N, M = map(int, input().split())
data = list(map(int, input().split()))
data.sort()
Sum = sum(data)
Max = max(data)
for i in Max:
    bisect_left(data, i)
