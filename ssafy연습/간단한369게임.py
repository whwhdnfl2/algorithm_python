N = int(input())

for i in range(1, N + 1):
    num = 0
    str_i = str(i)
    for j in str_i:
        if j == "3" or j == "6" or j == "9":
            num += 1
    if num == 1:
        print('-', end=' ')
    elif num == 2:
        print('--', end=' ')
    elif num == 3:
        print('---', end=' ')
    else:
        print(i, end=' ')
