import math

N = input()
ans = len(N)
#print(ans)
for i in range(1, math.floor(len(N) / 2) + 1):
    count = 1
    first = N[0:i]
    Long = ""
    for j in range(i, len(N), i):
        #print(first)
        if first == N[j:j+i]:
            count += 1
        elif first != N[j:j+i] and count == 1:
            count = 1
            Long += first
            first = N[j:j+i]
        else:
            Long += str(count) + first
            first = N[j:j+i]
            count = 1
    if count == 1:
        Long += first
    else:
        Long += str(count) + first
    #print(Long)
    if len(Long) < ans:
        ans = len(Long)

print(ans)






