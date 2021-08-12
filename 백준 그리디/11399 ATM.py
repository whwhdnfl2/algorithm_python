N = int(input())

people = list(map(int, input().split()))

people.sort()

price = 0

for i in people:
    price += i * N
    N -= 1

print(price)