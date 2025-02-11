# 1. 요소가 0으로 이루어져있고, 요소가 총 26개인 배열을 생성한다.
# 2. 0번째는 a, 25번째는 z의 빈도수를 가리킨다.
# 3. 받은 string을 반복문 처리하여 string을 아스키코드로 변환한다.
# 4. 변환한 아스키코드에서 아스키코드 a를 빼고, 해당 알파벳의 위치를 찾는다. (몇번째인지)
# 5. 몇번째인지를 찾는 곳에 1을 더한다.
# 6. 처음에 만든 배열에서 가장 빈도수가 많은 요소가 몇번째인지 구하고, 아스키코드 a를 더해서 다시 알파벳으로 변환한다.
# 7. 만약 빈도수가 같은게 있는지 찾고, 같은게 하나더 있으면 ?를 출력한다.
# 3N
T = int(input())

for i in range(T):
  array = input().replace(' ', '')
  repeats = [0] * 26
  
  for el in array:
    repeats[ord(el) - ord('a')] += 1

  max = 0
  maxOrder = 0
  repeatCount = 0

  for i in range(len(repeats)):
    if (max < repeats[i]):
      max = repeats[i]
      maxOrder = i

  for i in range(len(repeats)):
    if (repeats[i] == max):
      repeatCount += 1
    if (repeatCount == 2):
      break

  if (repeatCount == 2): print('?')
  else: print(chr(maxOrder + ord('a')))