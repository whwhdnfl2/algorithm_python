N = int(input())

all = []
Min = 400
Max = 0
for _ in range(N):
    a, b = map(int, input().split())
    if a % 2 == 0:
        a = a//2
    elif a % 2 == 1:
        a = (a+1) // 2
    if b % 2 == 0:
        b = b//2
    elif b % 2 == 1:
        b = (b+1) // 2
    if a > b:
        a, b = b, a
    print(a, b)
    if a < Min:
        Min = a
    if b > Max:
        Max = b
    all.append(tuple((a, b)))

ans = 0

for i in range(Min, Max + 1):
    temp_ans = 0
    for j in all:
        if i <= j[1] and i >= j[0]:
            temp_ans += 1
    if temp_ans > ans:
        ans = temp_ans
print(ans)