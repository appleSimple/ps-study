word = input().upper()

def answer(word):
  alphabet = [0] * 26
  for i in word:
    alphabet[ord(i) - ord('A')] += 1
  
  maxNum = max(alphabet)

  if (alphabet.count(maxNum) > 1):
    return '?'
  else:
    return chr(alphabet.index(maxNum)+ ord('A'))

print(answer(word))