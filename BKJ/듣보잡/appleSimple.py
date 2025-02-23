from sys import stdin

n, m = map(int, stdin.readline().split())
lines = (stdin.readline().strip() for _ in range(n+m))

seen = set()
duplicates = set()

for el in lines:
  if el in seen:
    duplicates.add(el)
  seen.add(el)

print(len(list(duplicates)))
print('\n'.join(sorted(list(duplicates))))
