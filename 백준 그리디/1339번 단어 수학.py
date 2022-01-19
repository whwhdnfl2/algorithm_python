N = int(input())

ans = 0

num = 9

word = []

for i in range(N):
    word.append(input())

print(word)

most_long = 0
long_count = 1

for i in range(N):
    if len(word[i]) > most_long:
        most_long = len(word[i])
        long_count = 1
    elif len(word[i]) == most_long:
        long_count += 1

for i in range(N):
    word[i]