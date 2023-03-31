N = int(input())
data = []
for i in range(N):
    data.append(input())
data.sort()
data.sort(key=lambda x: len(x))
before = ""
after = ""
for i in data:
    after = i
    if before == after:
        continue
    print(i)
    before = after
