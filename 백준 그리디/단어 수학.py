N = int(input())

data = [['A', 0], ['B', 0],['C', 0],['D', 0],['E', 0],['F', 0],['G', 0],['H', 0],['I', 0],['J', 0],['K', 0],['L', 0],
        ['M', 0],['N', 0],['O', 0],['P', 0],['Q', 0],['R', 0],['S', 0],['T', 0],['U', 0],['V', 0],['W', 0],['X', 0],['Y', 0],
        ['Z', 0]]
Input = []
for i in range(N):
    Input.append(input())

for i in Input:
    Long = len(i)
    for j in i:
        for k in data:
            if k[0] == j:
                k[1] += 10 ** Long
        Long -= 1

data.sort(key = lambda x:x[1], reverse=True)
ans = 0
for i in range(0,9):
    ans += (10 - (i + 1)) * data[i][1] / 10
print(int(ans))