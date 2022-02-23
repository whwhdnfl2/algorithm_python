N = int(input())
if N < 10:
    N *= 10
temp = str(N)
count = 0
while True:
    count += 1
    now = 0
    for i in temp:
        now += int(i)
    now2 = str(now)
    now = int(temp[-1]) * 10 + int(now2[-1])
    temp = str(now)
    if now == N:
        break
print(count)