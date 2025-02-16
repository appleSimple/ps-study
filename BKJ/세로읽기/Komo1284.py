 # 입력 - 총 다섯줄의 입력이 주어진다. 각 줄에는 최소 1개, 최대 15개의 글자들이 빈칸 없이 연속으로 주어진다.
 # 주어지는 글자는 영어 대문자 ‘A’부터 ‘Z’, 영어 소문자 ‘a’부터 ‘z’, 숫자 ‘0’부터 ‘9’ 중 하나이다. 각 줄의 시작과 마지막에 빈칸은 없다.

 # 출력 - 영석이가 세로로 읽은 순서대로 글자들을 출력한다. 이때, 글자들을 공백 없이 연속해서 출력한다.

 # 예제입력 - ABCDE
 #          abcde
 #          01234
 #          FGHIJ
 #          fghij

 # 예제출력 - Aa0FfBb1GgCc2HhDd3IiEe4Jj

# 5줄 입력받기
words = []
for _ in range(5):
    words.append(input())

# 가장 긴 문자열의 길이 찾기
max_len = max(len(word) for word in words)

# 세로로 읽기
result = ''
for i in range(max_len):  # 각 열을 순회
    for j in range(len(words)):  # 각 행을 순회
        # 현재 위치(i)가 해당 행의 길이보다 작을 때만 문자 추가
        if i < len(words[j]):
            result += words[j][i]

print(result)

print("zip함수를 이용한 문제풀이")
from itertools import zip_longest

# 5줄 입력받기
words = []
for _ in range(5):
    words.append(input())

# zip_longest를 사용해서 세로로 읽기
result = ''
for chars in zip_longest(*words, fillvalue=''):
    result += ''.join(chars)

# zip_longest는 일반 zip과 달리 가장 긴 이터러블의 길이에 맞춰서 동작합니다.
# fillvalue=''를 설정하여 짧은 문자열의 경우 빈 문자열로 채워줍니다.

print(result)


