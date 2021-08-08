n, k = map(int, input().split())

count = 0

while n != 1:
    count = count + 1
    if n % k == 0:
        n = n // k
        continue
    n = n - 1

print(count)