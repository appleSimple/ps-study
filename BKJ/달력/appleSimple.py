import sys

N = int(sys.stdin.readline().strip())
calendar = [0] * 366

for _ in range(N):
  S, E = map(int, sys.stdin.readline().strip().split())

  for i in range(S, E + 1):
    calendar[i] += 1

row = 0
col = 0
answer = 0

for i in range(0, len(calendar)):
  if calendar[i] != 0:
    row = max(row, calendar[i])
    col += 1
  else:
    answer += row * col
    row = 0
    col = 0

answer += row * col

print(answer)