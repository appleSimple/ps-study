print("숫자의 개수를 입력하세요 : ")
numLength = input()

print(numLength + "자리 숫자를 입력하세요 : ")
num = str(input())
count =0

for i in num:
    count += int(i)

print(count)
