# 영단어 암기는 어려워
# https://www.acmicpc.net/problem/20920

a , b = map(int, input().split())

dic = {}

for _ in range(a):
  str = input()

  if len(str) < b:
    continue

  if str in dic:
    dic[str] += 1
  else:
    dic[str] = 1

# 이게 뭔 소리지
sorted_dic = sorted(dic.items(), key=lambda x: (-x[1], -len(x[0]), x[0]))

for key, value in sorted_dic:
  print(key)

