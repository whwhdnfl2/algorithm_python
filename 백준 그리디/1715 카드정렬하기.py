N = int(input())

card = []

for _ in range(N):
    card.append(int(input()))

card.sort()

if N == 1:
    print(0)

else:
    ans = card[0] + card[1]
    now = ans

    while len(card) != 1:
        card[0] = now
        for i in range(card):
            if i == 0:
                pass
            else:
                card[i] = card[i + 1]

    print(ans)
