#입력: int 하나
N = int(input())
#입력: int 여러개
N, M = map(int, input().split())

#입력: N개의 줄로 여러개의 int 입력
N = int(input())
data1 = []
for i in range(N):
    data1.append(list(map(int, input().split())))

#입력: 홍길동 12
data2 = []
N = int(input())
for i in range(N):
    input_data = input().split() #list 형식으로 입력됨
    data2.append((input_data[0], int(input_data[1])))

#2차원 배열
data3 = [[0] * M for i in range(N)]