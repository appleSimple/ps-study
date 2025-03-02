import sys

N = int(sys.stdin.readline())
dic = {}

for _ in range(N):
  line = sys.stdin.readline().strip()

  arr = line.split('.')
  extension = arr.pop()
  if extension in dic:
    dic[extension] += 1
  else:
    dic[extension] = 1

for key in sorted(dic.keys()):
  print(key, dic[key])