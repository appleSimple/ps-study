# 수 이어 쓰기
# https://www.acmicpc.net/problem/1515

nums = list(input())  # 문자열을 한 글자씩 char로 변환

target = ""
idx = 0
i = 1

while idx != len(nums):
  target = str(i)
  i += 1

  for elem in list(target):
    if nums[idx] == elem:
      idx += 1
      if idx == len(nums):
        break

print(target)
