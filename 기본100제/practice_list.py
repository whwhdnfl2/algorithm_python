n = 10
a = [0] * n
print(a)

a = [1, 2, 3, 4, 5, 6, 7]
print(a[-1])

a[3] = 7
print(a)

print(a[-3:-1])

array = [i for i in range(20) if i % 2 == 1]
print(array)

array = [i * i for i in range(1, 10)]
print(array)

# N x M 크기의 2차원 리스트 초기화
n = 3
m = 4
array = [[0] * m for _ in range(n)]
print(array)

a = [1, 3, 3]
a.sort(reverse=True)
print(a)
a.insert(1, 2)
print(a)
a.remove(3)
print(a)

a = [1, 2, 3, 4, 5, 5, 5, 5]
remove_set = {3, 5}
result = [i for i in a if i not in remove_set]
print(result)