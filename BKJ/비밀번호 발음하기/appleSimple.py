import re
import sys

# 1. 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
# 2. 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다. re.findall(r"(.)\1+{2,0}", i)
# 3. 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
words = ['a', 'tv', 'ptoui', 'bontres', 'eeaadsdaa']
def answer(word):
  vowels = "aeiou"
  if not any(v in word for v in vowels):
    return False
    
  if re.search(r"(.)\1", word):  
    if not re.search(r"(ee|oo)", word):  
      return False

  if re.search(r"[aeiou]{3}|[^aeiou]{3}", word):  
    return False

  return True

for line in sys.stdin:
    password = line.strip()
    if password == "end":
        break
    if answer(password):
        print(f"<{password}> is acceptable.")
    else:
        print(f"<{password}> is not acceptable.")