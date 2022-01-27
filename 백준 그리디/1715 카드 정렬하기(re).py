import sys
import heapq

data = []
ans = 0
N = int(input())
for i in range(N):
    a = int(sys.stdin.readline())
    heapq.heappush(data, a)
ans = 0
for i in range(N - 1):
    a = heapq.heappop(data)
    b = heapq.heappop(data)
    ans += a + b
    heapq.heappush(data, a + b)
print(ans)

