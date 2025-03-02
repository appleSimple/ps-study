from sys import stdin

numbers = stdin.readline().strip()

count = 0
while len(numbers) > 0:
  count += 1
  result = str(count) # 2자리 이상 비교를 위해 string으로 변환
  while result and numbers:
    if result[0] == numbers[0]:
      numbers = numbers[1:]
    result = result[1:] # result가 2자리 이상이면 모두 비교해야하기 때문에, 첫자리 비교 후 둘째자리 비교 ..

print(count)