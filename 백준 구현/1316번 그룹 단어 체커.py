N = int(input())
data = []
for i in range(N):
    data.append(list(input()))

count = 0
for i in data:
    flag = False
    check = [
        ['a', 0],
        ['b', 0],
        ['c', 0],
        ['d', 0],
        ['e', 0],
        ['f', 0],
        ['g', 0],
        ['h', 0],
        ['i', 0],
        ['j', 0],
        ['k', 0],
        ['l', 0],
        ['m', 0],
        ['n', 0],
        ['o', 0],
        ['p', 0],
        ['q', 0],
        ['r', 0],
        ['s', 0],
        ['t', 0],
        ['u', 0],
        ['v', 0],
        ['w', 0],
        ['x', 0],
        ['y', 0],
        ['z', 0],
    ]
    for n in check:
        if i[0] == n[0]:
            n[1] += 1
    for j in range(1, len(i)):
        if i[j] == i[j-1]:
            continue
        else:
            for k in check:
                if i[j] == k[0]:
                    k[1] += 1
    for j in check:
        if j[1] > 1:
            flag = True
            break
    #print(check)
    if not flag:
        count += 1
print(count)
