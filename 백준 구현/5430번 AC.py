from collections import deque

def AC(data, command):
    flag = True
    for i in command:
        if i == 'R':
            flag = not flag
        elif len(data) > 0 and flag:
            data.popleft()
        elif len(data) > 0 and not flag:
            data.pop()
        else:
            print("error")
            return
    if not flag:
        data.reverse()
    if len(data) == 0:
        print("[]")
        return
    print("[", end='')
    #print(data)
    for j in range(len(data) - 1):
        print(str(data[j]) + ',', end='')
    print(str(data[len(data) - 1]) + "]")
    return


T = int(input())
for i in range(T):
    command = input()
    N = int(input())
    D = input()
    flag = False
    for j in command:
        if j == "D":
            flag = True
    if D == '[]' and flag:
        print("error")
        continue
    if D == '[]' and not flag:
        print("[]")
        continue
    D = D[1:-1]
    data = deque(list(map(int, D.split(','))))
    #print(data)
    AC(data, command)
