import sys

N = int(input())
dic = {}
count = 0

for i in range(0, N):
  key, value = sys.stdin.readline().strip().split()

  if key in dic:
    if (dic[key] != value):
      count += 1
      dic[key] = value
  else:
    dic[key] = value

print(count)