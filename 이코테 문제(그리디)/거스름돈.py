import math

List = [500, 100, 50, 10]

n = int(input())

count = 0 
for i in List:
    count += n // i
    n = n % i

print(count)