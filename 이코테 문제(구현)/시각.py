N = int(input())

time = 0
hour = 0
count = 0

while time != (N + 1) * 10000:
    time += 1
    if time % 100 == 60:
        time += 40
    if time % 10000 == 6000:
        time += 4000
    temp_time = str(time)
    for i in temp_time:
        if i == '3':
            count += 1
            break

print(count)