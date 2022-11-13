T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input())
    # ///////////////////////////////////////////////////////////////////////////////////
    ans_array = [0] * 101
    array = list(map(int, input().split()))
    
    for i in array:
        ans_array[i] += 1
    
    ans = 0
    array_num = 0
    for i in range(len(ans_array)):
        if ans_array[i] >= ans:
            ans = ans_array[i]
            array_num = i

    print("#" + str(test_case) + " " + str(array_num))
    # ///////////////////////////////////////////////////////////////////////////////////