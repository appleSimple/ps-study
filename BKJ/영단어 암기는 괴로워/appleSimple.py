from sys import stdin

# 메모리가 효율적인 방법인 제너레이터 사용..
n, m = map(int, stdin.readline().split())
lines = (stdin.readline().strip() for _ in range(n))

dic = {}

for word in lines:
  if len(word) < m:
    continue
  else:
    if word in dic:
      dic[word] += 1
    else:
      dic[word] = 1

for i in sorted(dic.keys(), key = lambda x: (-dic[x], -len(x), x)):
  print(i)