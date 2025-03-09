import sys

money = int(input())
lines = list(map(int, sys.stdin.readline().strip().split()))

bnp = money
bnpCount = 0

timing = money
timingCount = 0

transition = 0

yesterday = lines[0]
lastDay = lines[-1]

for today in lines:
  if today <= bnp:
    buyCount = bnp // today
    bnpCount += buyCount
    bnp -= today * buyCount
  
  if yesterday > today:
    transition -= 1
  elif yesterday < today:
    transition += 1
  else:
    transition = 0
  
  if transition == -3 and timing >= today:
    buyCount = timing // today
    timingCount += buyCount
    timing -= today * buyCount
    transition = 0
  elif transition == 3 and timingCount > 0:
    timing += timingCount * today
    timingCount = 0
    transition = 0

  yesterday = today

bnpTotal = bnpCount * lastDay + bnp
timingTotal = timingCount * lastDay + timing

if (bnpTotal > timingTotal):
  print('BNP')
elif (bnpTotal < timingTotal):
  print('TIMING')
elif (bnpTotal == timingTotal):
  print('SAMESAME')
