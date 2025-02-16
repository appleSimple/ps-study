
while 1:
  str = input()

  if str == 'end':
    break

  success = True
  a = [0] * 64

  flag = False
  for elem in str:
    if elem == 'a' or elem == 'e' or elem == 'i' or elem == 'o' or elem == 'u':
      flag = True
      break

  if flag == False:
    success = False

  gathers = {'a', 'e', 'i', 'o', 'u'}  # 모음 집합
  gathers_count = 0
  consonant_count = 0
  for elem in str:
    if elem in gathers:  # 모음 확인
      gathers_count += 1
      consonant_count = 0  # 자음 개수 초기화
    else:
      consonant_count += 1
      gathers_count = 0  # 모음 개수 초기화

    if gathers_count == 3 or consonant_count == 3:  # 연속 3개 검사
      success = False

  for i in range(len(str) - 1):
    if str[i] == str[i + 1] and str[i:i+2] not in ("ee", "oo"):
      success = False

  if success == False:
    print ('<' + str + '>' + ' is not acceptable.')
  else:
    print ('<' + str + '>' + ' is acceptable.')

