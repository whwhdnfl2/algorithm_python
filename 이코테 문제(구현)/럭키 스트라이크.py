N = str(input())

Long_N = int(len(N) / 2)

Long1_N = N[0:Long_N]
Long2_N = N[Long_N:]

ans1 = 0
ans2 = 0
for i in Long1_N:
    ans1 += int(i)

for i in Long2_N:
    ans2 += int(i)
if ans2 == ans1:
    print("LUCKY")
else:
    print("READY")