import heapq
import sys

N = int(input())
data = []
for i in range(N):
    a = sys.stdin.readline()
    data.append(list(map(int, a.split())))
data.sort(key=lambda x: x[0])
heap = []
ans = 1
for i in data:
    if len(heap) == 0:
        heapq.heappush(heap, i[1])
    else:
        while True:
            if len(heap) == 0:
                #heapq.heappush(heap, i)
                break
            ob = heapq.heappop(heap)
            if ob > i[0]:
                heapq.heappush(heap, ob)
                break
        heapq.heappush(heap, i[1])
        if ans < len(heap):
            ans = len(heap)
print(ans)
