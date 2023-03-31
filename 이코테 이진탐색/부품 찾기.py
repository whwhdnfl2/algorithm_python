N = int(input())
data1 = list(map(int, input().split()))
M = int(input())
data2 = list(map(int, input().split()))

data1.sort()


def bisect(data, a, b, target):
    start = a
    end = b
    while start <= end:
        mid = (start + end) // 2
        if data[mid] == target:
            return mid
        elif data[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return -1


for i in data2:
    ans = bisect(data1, 0, N - 1, i)
    if ans == -1:
        print("no")
    else:
        print("yes")
