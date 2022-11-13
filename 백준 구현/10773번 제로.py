K = int(input())

q = []

for i in range(K):
    a = int(input())
    if a != 0:
        q.append(a)
    else:
        q.pop()

ans = 0
for i in q:
    ans += i
print(ans)