N, M = map(int, input().split())

array = list(map(int, input().split()))

start = 0
end = max(array)

ans = 0

while start <= end:
    total = 0
    mid = (start + end) // 2
    for i in array:
        if i > mid:
            total += i - mid
    if total >= M:
        ans = mid
        start = mid + 1
    if total < M:
        end = mid - 1

print(ans)
    
