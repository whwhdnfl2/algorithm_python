N = int(input())

tower = list(map(int, input().split()))

ans = 0
for i in range(2, len(tower) - 2):
    top = max(tower[i - 2], tower[i-1], tower[i + 1], tower[i + 2])
    if tower[i] > top:
        ans += tower[i] - top

print(ans)