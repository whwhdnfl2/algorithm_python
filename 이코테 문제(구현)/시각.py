N = int(input())

a = "asdfg"
print(a[-2])

result = 0
for i in range(N + 1):
    if i == 3 or i == 13 or i == 23:
        result += 3600
     #   print("ssibal")
        continue
    for j in range(60):
        temp_j = "0" + str(j)
        if temp_j[-2] == "3" or temp_j[-1] == "3":
            result += 60
          #  print("good")
            continue
        for k in range(60):
            temp_k = "0" + str(k)
            if temp_k[-2] == "3" or temp_k[-1] == "3":
                result += 1
               # print("ssibal")

print(result)