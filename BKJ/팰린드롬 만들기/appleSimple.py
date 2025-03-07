string = input()

def answer(string):
  arr = [0] * 26
  for el in string:
    arr[ord(el) - ord('A')] += 1
  
  odd = 0
  even = 0

  for count in arr:
    if (count == 0):
      continue
    elif (count % 2 == 0):
      even += 1
    else:
      odd += 1
  
  if (odd > 1):
    print("I'm Sorry Hansoo")
  else:
    strArr = [''] * len(string)
    mid = ''
    for i in range(len(arr)):
      if (arr[i] % 2 == 1):
        mid = chr(i + ord('A'))

      _count = arr[i] // 2
      while (_count > 0):
        strArr.append(chr(i + ord('A')))
        _count -= 1
    
    print(''.join(strArr) + mid + ''.join(strArr[::-1]))
        

answer(string)