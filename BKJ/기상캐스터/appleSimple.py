import sys

H, W = list(map(int, sys.stdin.readline().strip().split()))

sky = []
for i in range(H):
  cloud = sys.stdin.readline().strip()
  line = []
  for j in range(W):
    if cloud[j] == 'c':
      line.append(0)
    else:
      if j > 0 and line[j-1] >= 0:
        line.append(line[j-1] + 1)
      else:
        line.append(-1)
  
  sky.append(line)

for el in sky:
  print(" ".join(map(str, el)))