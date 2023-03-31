from bisect import bisect_left, bisect_right

N, M = map(int, input().split())
data = list(map(int, input().split()))

left = bisect_left(data, M)
right = bisect_right(data, M)
if left - right == 0:
    print(-1)
else:
    print(right - left)