S = input()

array = [str(i) for i in range(10)]

num = 0
new_S = ""
for i in S:
    if i in array:
        num += int(i)
    else:
        new_S += i


new_S = sorted(new_S)

if num !=0:
    new_S += str(num)
ans = ""

for i in new_S:
    ans += i
print(ans)
