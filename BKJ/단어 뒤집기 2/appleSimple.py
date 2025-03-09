import sys
import re

string = sys.stdin.read().strip()

split_list = re.split(r'(<[^>]+>)', string)

result = []

for part in split_list:
    if part.startswith('<') and part.endswith('>'):
      result.append(part)
    else:
      words = part.split()
      reversed_words = [word[::-1] for word in words]
      result.append(' '.join(reversed_words))

print(''.join(result))