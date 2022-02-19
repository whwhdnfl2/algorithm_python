import sys

data = []
N, K = map(int, input().split())
for i in range(N):
    a = sys.stdin.readline()
    data.append(list(map(int, a.split())))

data = sorted(data, key=lambda x: x[3], reverse=True)
data = sorted(data, key=lambda x: x[2], reverse=True)
data = sorted(data, key=lambda x: x[1], reverse=True)
#print(data)
flag = False
for i in range(N):
    if flag:
        break
    if data[i][0] == K:
        flag = True
        for j in range(i, -1, -1):
            #print(j)
            if data[j][1] != data[i][1] or data[j][2] != data[i][2] or data[j][3] != data[i][3]:
                print(j + 2)
                break
