number = [0] * 10001

def n(num):
    Strnum = str(num)
    ans = 0
    for i in Strnum:
        ans += int(i)
    ans += num
    if ans > 10000:
        return
    else:
        number[ans] = 1
        n(ans)

for i in range(1, 10000):
    if number[i] == 1:
        continue
    else:
        n(i)

for i in range(1, len(number)):
    if number[i] == 0:
        print(i)
