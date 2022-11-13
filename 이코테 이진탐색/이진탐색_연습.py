#이진탐색 구현(반복문)

array = []


start = 0
end = max(array)

while (start <= end):
    mid = (start + end) // 2
    if array[mid] == target:
        break
    if array[mid] < target:
        end = mid - 1
    else:
        start = mid + 1
