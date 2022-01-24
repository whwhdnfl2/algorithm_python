data = [0] * 101
N = int(input())
eat = list(map(int, input().split()))

data[0] = eat[0]
data[1] = max(eat[0], eat[1])
#data[2] = max(eat[1], eat[0] + eat[2])
for i in range(2, N):
    #data[i] = data[i - 3] + eat[i]
    data[i] = max(data[i], data[i - 1])
    data[i] = max(data[i], data[i - 2] + eat[i])
print(data[N - 1])


#책 정답임.
# 정수 N을 입력 받기
n = int(input())
# 모든 식량 정보 입력 받기
array = list(map(int, input().split()))

# 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화
d = [0] * 100

# 다이나믹 프로그래밍(Dynamic Programming) 진행 (보텀업)
d[0] = array[0]
d[1] = max(array[0], array[1])
for i in range(2, n):
    d[i] = max(d[i - 1], d[i - 2] + array[i])

# 계산된 결과 출력
print(d[n - 1])