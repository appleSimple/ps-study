# 최대 5개의 행을 저장할 리스트 초기화
arr = [list(input().strip()) for _ in range(5)]

# 최대 열 길이 찾기 (가장 긴 문자열의 길이)
max_length = max(len(row) for row in arr)

# 세로 방향으로 한 줄로 출력
result = []
for i in range(max_length):  # 가장 긴 문자열의 길이만큼 반복
  for row in arr:
    if i < len(row):  # 현재 인덱스가 유효한 경우만 추가
      result.append(row[i])

print("".join(result))  # 리스트를 문자열로 변환하여 출력