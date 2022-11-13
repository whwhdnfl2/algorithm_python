from collections import deque
from copy import deepcopy
import sys
input = sys.stdin.readline

N = int(input())
array1 = list(map(int, input().split()))
array2 = list(map(int, input().split()))

first = array1[0]

def bfs():
    Min = 1e9
    Max = -1e9
    queue = deque()
    queue.append([array1[0], 0, array2])
    while queue:
        num, count, myarray = queue.popleft()
        if count == N - 1:
            if Min > num:
                Min = num
            if Max < num:
                Max = num
        else:
            for i in range(4):
                if myarray[i] != 0:
                    if i == 0:
                        temp_num = num + array1[count + 1]
                        temp_array = deepcopy(myarray)
                        temp_array[i] -= 1
                        queue.append([temp_num, count + 1, temp_array])
                    if i == 1:
                        temp_num = num - array1[count + 1]
                        temp_array = deepcopy(myarray)
                        temp_array[i] -= 1
                        queue.append([temp_num, count + 1, temp_array])
                    if i == 2:
                        temp_num = num * array1[count + 1]
                        temp_array = deepcopy(myarray)
                        temp_array[i] -= 1
                        queue.append([temp_num, count + 1, temp_array])
                    if i == 3:
                        if num < 0:
                            temp_num = -(abs(num) // array1[count + 1])
                            temp_array = deepcopy(myarray)
                            temp_array[i] -= 1
                            queue.append([temp_num, count + 1, temp_array])
                        else:
                            temp_num = num // array1[count + 1]
                            temp_array = deepcopy(myarray)
                            temp_array[i] -= 1
                            queue.append([temp_num, count + 1, temp_array])
    return Min, Max

a, b = bfs()
print(a, b)