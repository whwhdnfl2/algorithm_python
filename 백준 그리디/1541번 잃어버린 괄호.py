N = input()

Ns = N.split('-')

temp = Ns[0].split('+')

ans = 0

for i in temp:
    ans += int(i)

temp_ans = 0

for i in range(1, len(Ns)):
    temp_Ns = Ns[i].split('+')
    for j in temp_Ns:
        temp_ans += int(j)
    ans -= temp_ans
    temp_ans = 0

print(ans)
