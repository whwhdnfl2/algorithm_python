#아이디어 자체는 맞았으나 구현에서 막힘

def solution(food_times, k):
    left_count = k

    if sum(food_times) <= left_count:
        return -1

    count = 0
    while True:
        print(food_times)
        for i in range(0, len(food_times)):
            if food_times[i] > 0:
                count += 1
        Min = min(food_times)

        if left_count - Min * count > 0:
            print("good")
            print(Min)
            left_count -= Min * count
            for i in range(0, len(food_times)):
                food_times[i] -= Min
        else:
            if sum(food_times) <= left_count:
                return -1
            while True:
                for i in range(0, len(food_times)):
                    if food_times[i] > 0:
                        if left_count == 0:
                            return i + 1
                    if food_times[i] > 0:
                        left_count -= 1
                        food_times[i] -= 1

        for i in food_times:
            if i > 0:
                i -= Min
        count = 0

print(solution([3, 1, 2], 5))