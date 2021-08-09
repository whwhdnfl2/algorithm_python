S = input()
num = 0

alphabet = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'

ans = ''
for alp in S:
    if int(ord(alp)) - int(ord('A')) < 0:
        num += int(alp)

for i in alphabet:
    for alp in S:
        if alp == i:
            ans += alp

ans += str(num)
print(ans)