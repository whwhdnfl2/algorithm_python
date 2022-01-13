import math
from itertools import permutations
from itertools import combinations
from itertools import product
from itertools import combinations_with_replacement

result = sum([1,2,3,4,5])
print(result)

result = min([1,2,3,4,5])
print(result)

result = eval("3 + 1")
print(result)

data = ['A', 'B', 'C']
result = list(permutations(data, 3))
print(result)
result = list(permutations(data, 2))
print(result)

result = list(combinations(data, 3))
print(result)
result = list(combinations(data, 2))
print(result)

result = list(product(data, repeat=3))
print(result)
result = list(product(data, repeat=2))
print(result)

result = list(combinations_with_replacement(data, 3))
print(result)
result = list(combinations_with_replacement(data, 2))
print(result)