from collections import deque
from copy import deepcopy

N = int(input())
number = list(map(int, input().split()))
yon = list(map(int, input().split()))



def bfs(good, yon1):
    queue = deque()
    queue.append([0, good, yon1])
    max = -999999999
    min = 999999999
    while queue:
        count, num, temp = queue.popleft()
        if count == N - 1:
            if num > max:
                max = num
            if num < min:
                min = num
        else:
            if temp[0] != 0:
                temp2 = deepcopy(temp)
                temp2[0] -= 1
                queue.append([count + 1, num + number[count + 1], temp2])
            if temp[1] != 0:
                temp2 = deepcopy(temp)
                temp2[1] -= 1
                queue.append([count + 1, num - number[count + 1], temp2])
            if temp[2] != 0:
                temp2 = deepcopy(temp)
                temp2[2] -= 1
                queue.append([count + 1, num * number[count + 1], temp2])
            if temp[3] != 0:
                if num < 0:
                    temp2 = deepcopy(temp)
                    temp2[3] -= 1
                    queue.append(([count + 1, -(abs(num) // number[count + 1]), temp2]))
                else:
                    temp2 = deepcopy(temp)
                    temp2[3] -= 1
                    queue.append(([count + 1, num // number[count + 1], temp2]))
    return max, min


ans_max, ans_min = bfs(number[0], yon)
print(ans_max)
print(ans_min)
