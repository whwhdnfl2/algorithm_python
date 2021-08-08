n = str(input())

result = 0

for i in range(len(n)):
    if result == 0:
        result = result + int(n[i])
    else:
        if int(n[i]) == 0 or int(n[i]) == 1:
            result = result + int(n[i])
        else:
            result = result * int(n[i])

print(result)