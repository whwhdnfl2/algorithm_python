N = input()
ans = len(N)

for i in range(2, len(N) - 1):
    for j in range(0, len(N - 1)):
        N[j:j+i] == N[j+i:j+(2*i)]