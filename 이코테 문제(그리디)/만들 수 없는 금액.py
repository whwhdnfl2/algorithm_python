#다시 해보기

N = int(input())
data = list(map(int, input().split()))
data.sort()

target = 1
for i in data:
    print(target)
    if i > target:
        break
    target += i

print(target)
