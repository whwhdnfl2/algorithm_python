import math

n = 6000000

win = 1 / math.comb(50,6)
print(math.comb(n, 4) * win ** 4 * (1 - win) ** (n - 4))