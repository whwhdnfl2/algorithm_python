import sys

#데이터 하나 입력 ) 5
n = int(input())
#데이터 여러개 입력 ) 65 90 75 34 99
data = list(map(int, input().split()))
#데이터 여러개 입력 ) 5 7 9
n, m, k = map(int, input().split())

print(data)
print(n, m, k)

#빠르게 입력
data = sys.stdin.readline().rstrip()
print(data)
