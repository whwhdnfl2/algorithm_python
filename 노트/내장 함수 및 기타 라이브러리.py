#내장 함수
array = [1, 2, 3, 4]

result = sum(array)
result = max(array)
result = sorted(array)
result = sorted(array, reverse=True)

array = [('홍길동', 35), ('이순신', 70), ('아무개', 40)]

result = sorted(array, key=lambda x:x[1], reverse = True)



#순열 조합
from itertools import permutations
from itertools import combinations

data = ['A', 'B', 'C']
result = list(permutations(data, 3))#순열
print(result)

result = list(combinations(data, 2))#조합
print(result)



#heap
#heap은 넣고 빼는 것은 logn으로 구현 가능. 그러므로 heapsort 구현 가능.
import heapq

def heapsort(iterable):
    h = []
    result = []
    for i in iterable:
        heapq.heappush(h, i)
    for _ in range(len(h)):
        result.append(heapq.heappop(h))
    return result

result = heapsort([1,5,7,4,2,4,5,7,8,2,4])
print(result)



#queue
#deque는 앞뒤로 데이터를 넣고 뺄 수 있다. O(1)에 연산이 일어나므로 queue와 stack을 대신하여 사용할 수 있다.
from collections import deque

data = deque([2, 3, 4])
data.appendleft(1)
data.append(5)

print(list(data))



#math
import math

math.factorial(5)

math.sqrt(7)#제곱근

math.pi

math.pow(2, 3)

def lcm(a,b):
	return a * b // math.gcd(a,b)

math.gcd(14, 21)#최대공약수
lcm(14,21)#최소공배수



#Counter
from collections import Counter

counter = Counter([1, 3, 1, 3, 2, 4, 2, 5])

print(counter[1])
print(dict(counter))