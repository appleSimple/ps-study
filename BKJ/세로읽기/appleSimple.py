# 1. 15개의 빈스트링을 가진 5개의 2차원 배열을 생성
# 2. 받은 스트링을 각 배열에 할당
# 3. 세로 순서대로 반복문을 돌리며 스트링을 더해서 출력
# N^2 + N

words = [input() for i in range(5)]

def answer(array):
  arr = [[''] * 15 for _ in range(5)]

  for i in range(len(array)):
    for j in range(len(array[i])):
      arr[i][j] = array[i][j]
  
  str = ''
  i = 0
  k = 0
  while(k < 15):
    str += arr[i][k]
    i += 1
    if (i == len(arr)):
      i = 0
      k += 1

  return str

print(answer(words))