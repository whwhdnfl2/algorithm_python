#선택 정렬
array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]
for i in range(len(array)):
    Min = i
    for j in range(i+1, len(array)):
        if array[j] < array[Min]:
           Min = j
    array[i], array[Min] = array[Min], array[i]


#삽입 정렬
array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(1, len(array)):
    for j in range(i, 0, -1):
        if array[j] < array[j-1]:
            array[j], array[j-1] = array[j-1], array[j]
        else:
            break

#퀵 정렬
array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

def quick_sort(array):
    if len(array) <= 1:
        return array
    pivot = array[0]
    tail = array[1:]

    left_side = [x for x in tail if x <= pivot]
    right_side = [x for x in tail if x > pivot]

    return quick_sort(left_side) + [pivot] + quick_sort(right_side)

quick_sort(array)
print(array)
#계수 정렬

array = [7, 5, 9, 0, 3, 1, 6, 2, 9, 4, 8, 0, 5, 2]

data = [0] * (max(array) + 1)
for i in array:
    data[i] += 1
for i in range(len(data)):
    for j in range(data[i]):
        print(i, end=' ')
