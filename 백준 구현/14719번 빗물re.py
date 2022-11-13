H, W = map(int, input().split())

wall = list(map(int, input().split()))

ans = 0
for i in range(1, W-1):
    left_max = max(wall[:i])
    right_max = max(wall[i+1:])
    good = min(left_max, right_max)
    if good > wall[i]:
        ans += good - wall[i]

print(ans)