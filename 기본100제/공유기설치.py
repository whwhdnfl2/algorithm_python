import sys
input = sys.stdin.readline

def binary_search(array, start, end, num):
    now = 0
    ans = 0
    while now != num:
        now += 1
        mid = (start + end) // 2
        ans = max(array[mid] - array[start], array[end] - array[mid])
        if min(array[(mid + start) // 2] - array[start], array[mid] - array[(mid + start) // 2]) >= min(array[(mid + end) // 2] - array[mid], array[end] - array[(mid + end) // 2]):
            end = mid
        else:
            start = mid
    return ans
            


N, C = map(int, input().split())

array = []
for i in range(N):
    array.append(int(input()))

array = sorted(array)
home = [0] * (array[-1] + 1)

if C == 2:
    print(array[-1] - array[0])
else:
    print(binary_search(array, 0, len(array) - 1, C))



