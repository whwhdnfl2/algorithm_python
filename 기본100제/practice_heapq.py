import heapq

h = [7, 5, 12, 8, 4, 6]

result = []

for i in h:
    heapq.heappush(result, i)

print(list(result))
