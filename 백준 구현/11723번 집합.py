import sys
N = int(sys.stdin.readline().rstrip())

array = [0] * 21
for _ in range(N):
    order = sys.stdin.readline().rstrip()
    if order[:2] == "ad":
         array[int(order[-2:])] = 1
    elif order[:2] == "re":
        array[int(order[-2:])] = 0
    elif order[:2] == "ch":
        print(array[int(order[-2:])])
    elif order[:2] == "to":
        if array[int(order[-2:])] == 0:
            array[int(order[-2:])] = 1
        else:
            array[int(order[-2:])] = 0
    elif order[:2] == "al":
        array = [1] * 21
    else:
        array = [0] * 21