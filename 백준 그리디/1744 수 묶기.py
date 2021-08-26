N = int(input())

number = []

for i in range(N):
    number.append(int(input()))

number.sort()

ans = 0

plus = []
minus = []
for i in range(N):
    if number[i] > 0:
        plus.append(number[i])
    else:
        minus.append(number[i])


i = len(plus) - 1

if len(plus) % 2 == 1:
    while i != 0:
        if plus[i] == 1 or plus[i-1] == 1:
            ans = ans + plus[i] + plus[i-1]
            i = i - 2
        else:
            ans = ans + plus[i]*plus[i-1]
            i = i - 2
    ans = ans + plus[0]
else:
    while i != -1:
        if plus[i] == 1 or plus[i-1] == 1:
            ans = ans + plus[i] + plus[i-1]
            i = i - 2
        else:
            ans = ans + plus[i]*plus[i-1]
            i = i - 2
i = 0
if len(minus) % 2 == 1:
    while i != len(minus) - 1:
        ans = ans + minus[i]*minus[i+1]
        i = i + 2
    if 0 in number:
        pass
    else:
        ans += minus[len(minus) - 1]
else:
    while i != len(minus):
        ans = ans + minus[i]*minus[i+1]
        i = i + 2
print(ans)
