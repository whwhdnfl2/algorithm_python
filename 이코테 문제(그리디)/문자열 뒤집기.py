string = input()

one_count = 0
zero_count = 0

before = 'a'
for i in string:
    if i == '0':
        if i != before:
            one_count += 1
            before = i
    else:
        before = i

for i in string:
    if i == '1':
        if i != before:
            zero_count += 1
            before = i
    else:
        before = i

print(min(zero_count, one_count))