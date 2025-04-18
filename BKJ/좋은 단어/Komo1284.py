# 백준 3986번: 좋은 단어
# https://www.acmicpc.net/problem/3986

def is_good_word(word):
    """
    주어진 단어가 '좋은 단어'인지 확인하는 함수

    좋은 단어의 조건:
    1. 연속적으로 같은 글자가 마주보는 두 글자인 경우 제거 가능
    2. 모든 글자를 제거할 수 있으면 '좋은 단어'

    스택을 사용하여 문제를 해결
    """
    # 스택 초기화
    stack = []

    # 단어의 각 글자에 대해 반복
    for char in word:
        # 스택이 비어있지 않고 현재 글자가 스택의 맨 위 글자와 같은 경우
        if stack and stack[-1] == char:
            # 같은 글자이면 스택에서 제거
            stack.pop()
        else:
            # 다른 글자이면 스택에 추가
            stack.append(char)

    # 스택이 비어있으면 모든 글자를 제거할 수 있음 (좋은 단어)
    return len(stack) == 0


# 입력 받기
n = int(input())

# 좋은 단어의 개수를 세는 변수
good_word_count = 0

# n개의 단어에 대해 반복
for _ in range(n):
    word = input().strip()

    # 좋은 단어인지 확인하고 카운트
    if is_good_word(word):
        good_word_count += 1

# 결과 출력
print(good_word_count)