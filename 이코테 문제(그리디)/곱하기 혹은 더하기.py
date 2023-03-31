n = str(input())
n = int(n)
n = str(n)

ans = 0
for i in range(len(n)):
    if i == 0:
        ans += int(n[i])
    else:
        if n[i] == "0" or n[i] == "1":
            ans += int(n[i])
        else:
            ans *= int(n[i])

print(ans)
    
