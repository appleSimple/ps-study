import sys

H, W = map(int, sys.stdin.readline().strip().split())
blocks = list(map(int, sys.stdin.readline().strip().split()))
answer = 0

for i in range(1, W - 1):
  left = max(blocks[:i])
  right = max(blocks[i+1:])

  min_block = min(left, right)

  if blocks[i] < min_block:
    answer += min_block - blocks[i]

print(answer)