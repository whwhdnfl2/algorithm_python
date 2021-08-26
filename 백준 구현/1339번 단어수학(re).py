#딕셔너리로 중요도를 체크해보자.

N = int(input())

word = []

for i in range(N):
    word.append(input())

print(word)

most_long = 0
for i in range(N):
    if word[i]