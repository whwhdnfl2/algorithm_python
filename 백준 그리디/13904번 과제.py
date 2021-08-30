N = int(input())

assign = []

for i in range(N):
    assign.append(list(map(int, input().split())))

assign.sort(reverse=True, key=lambda x: x[1])
assign.sort(reverse=True, key=lambda x: x[0])

count = int(assign[0][0])
ans = 0

noans = 0
delete = -1
for _ in range(assign[0][0]):
    for i in range(N):
        if assign[i][0] >= count and assign[i][1] > noans:
            noans = assign[i][1]
            delete = i
    if delete == -1:
        count -= 1
        continue
    ans += noans
    del assign[delete]
    delete = -1
    noans = 0
    count -= 1
    N -= 1

print(ans)
