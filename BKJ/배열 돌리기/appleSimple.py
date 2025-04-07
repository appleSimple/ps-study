def repeat(op):
    temp1 = []
    temp2 = []
    temp3 = []
    temp4 = []

    for i in range(n):
        temp1.append(maps[i][n//2])
        temp2.append(maps[n-1-i][i])
        temp3.append(maps[n//2][i])
        temp4.append(maps[i][i])

    if op == "+":
        for i in range(n):
            maps[0+i][n-1-i] = temp1[i]
            maps[n//2][i] = temp2[i]
            maps[i][i] = temp3[i]
            maps[i][n//2] = temp4[i]

    else:
        for i in range(n):
            maps[i][i] = temp1[i]
            maps[n//2][i] = temp4[i]
            maps[n-1-i][i] = temp3[i]
            maps[i][n//2] = temp2[-1-i]


t = int(input())

for _ in range(t):
    n, d = map(int, input().split())
    maps = [list(map(int, input().split())) for _ in range(n)]
    if d < 0: op = "-"
    else: op = "+"
    for i in range(abs(d)//45):
        repeat(op)

    for i in range(n):
        for j in range(n):
            print(maps[i][j],end=" ")
        print()