#시뮬레이션문제 풀때는 dx = [0, 0, -1, 1]와 같이 방향벡터 이용해서 풀어보기
#ord() -> 아스키코드로 변환

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
move = ['L', 'R', 'U', 'D']

a = input()
first_x = int(ord(a[0])) - int(ord('a')) + 1
second_y = int(a[1])

x, y = first_x, second_y

count = 0

move_law = ['LLU', 'LLD', 'LUU', 'LDD', 'RRU', 'RRD', 'RUU', 'RDD']

for law in move_law:
    for alp in law:
        for i in range(len(move)):
            if alp == move[i]:
                x += dx[i]
                y += dy[i]
    if x > 0 and y > 0:
        count += 1
    x, y = first_x, second_y

print(count)


