N = int(input())
data = list(map(int, input().split()))
data.sort()
if len(data) % 2 == 1:
    ans = (len(data) // 2) + 1
    print(data[ans - 1])
else:
    ans1 = (len(data) // 2)
    count1 = 0
    ans2 = (len(data) // 2) + 1
    count2 = 0
    for i in range(ans1):
        count1 += i
    for i in range(ans1, len(data)):
        count1 += i
    for i in range(ans2):
        count2 += i
    for i in range(ans2, len(data)):
        count2 += i
    #print(count1, count2)
    if count1 <= count2:
        print(data[ans1 - 1])
    else:
        print(data[ans2 - 1])