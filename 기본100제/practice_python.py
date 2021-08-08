m = 5
n = 7

array1 = [i for i in range(20) if i % 2 == 1] #list 컴프리헨션
array2 = [[0] * m for _ in range(n)] #2차원 리스트
print(array2)

n = int(input()) #기본 입출력

print(n)

a, b, c = map(int, input().split())
print(a, b, c)