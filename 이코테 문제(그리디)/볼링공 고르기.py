N, M = map(int, input().split())
ball = list(map(int, input().split()))

ball.append(11)
ball.sort()

total_num = N * (N - 1) / 2

before = 0
count = 1
for i in ball:
    if i != before:
        before = i
        total_num -= count * (count - 1) / 2
        count = 1
        continue
    before = i
    count += 1

print(int(total_num))