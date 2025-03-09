import sys

# 1: i 전구의 상태를 x로 변경
# 2: l -> r까지 상태를 변경
# 3: l -> r까지 끄기
# 4: l -> r까지 켜지

N, M = map(int, sys.stdin.readline().strip().split())
bulbs = list(map(int, sys.stdin.readline().strip().split()))

def changeState(state):
  if (state == 1):
    return 0
  else:
    return 1

for n in range(0, M):
  com, b, c = map(int, sys.stdin.readline().strip().split())

  _b = b - 1
  _c = c - 1

  if (com == 1):
    bulbs[_b] = c
  elif (com == 2):
    for i in range(0, len(bulbs)):
      if (i >= _b and i <= _c):
        bulbs[i] = changeState(bulbs[i])
  elif (com == 3):
    for i in range(0, len(bulbs)):
      if (i >= _b and i <= _c):
        bulbs[i] = 0
  elif (com == 4):
    for i in range(0, len(bulbs)):
      if (i >= _b and i <= _c):
        bulbs[i] = 1

print(' '.join(map(str, bulbs)))