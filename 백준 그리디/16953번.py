A, B = map(int, input().split())

count = 0
STRB = str(B)
if B == A:
    print(count)
while True:
    if STRB[len(STRB) - 1] == '1':
        STRB = STRB[:len(STRB) - 1]
        B = int(STRB)
        count += 1
    elif int(STRB) % 2 == 0:
        B /= 2
        B = int(B)
        STRB = str(B)
        count += 1
    else:
        print(-1)
        break

    if B < A:
        print(-1)
        break
    if B == A:
        print(count + 1)
        break
