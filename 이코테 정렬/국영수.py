N = int(input())
data = []
for i in range(N):
    name, korean, english, math = input().split()
    korean = int(korean)
    english = int(english)
    math = int(math)
    insert = (name, korean, english, math)
    data.append(insert)

data.sort(key=lambda x: x[0])
data.sort(key=lambda x: x[3], reverse=True)
data.sort(key=lambda x: x[2])
data.sort(key=lambda x: x[1], reverse=True)

for i in data:
    print(i[0])
