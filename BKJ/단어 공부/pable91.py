str = input()

a = [0] * 128

for elem in str:
  a[ord(elem.upper())] += 1

tmp = 0
flag = False
idx = 0

for index, elem in enumerate(a):
  if tmp == elem:
    tmp = elem
    flag = True
    idx = index
  elif tmp < elem:
    tmp = elem
    flag = False
    idx = index

if flag == True:
  print('?')
else:
  print(chr(idx))
