N = input()
number = []
ans = ""
for i in N:
    number.append(int(i))
number.sort()
if number[0] != 0:
    print(-1)
elif sum(number) % 3 != 0:
    print(-1)
else:
    number.sort(reverse=True)
    for i in number:
        ans = ans + str(i)
print(ans)