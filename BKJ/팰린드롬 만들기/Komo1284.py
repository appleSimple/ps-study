def make_palindrome(name):
    # 각 문자의 빈도수 계산
    char_count = {}
    for char in name:
        if char in char_count:
            char_count[char] += 1
        else:
            char_count[char] = 1

    # 홀수 빈도수를 가진 문자 확인
    odd_char = None
    odd_count = 0
    for char, count in char_count.items():
        if count % 2 != 0:
            odd_char = char
            odd_count += 1

    # 홀수 빈도수를 가진 문자가 2개 이상이면 팰린드롬을 만들 수 없음
    if odd_count > 1:
        return "I'm Sorry Hansoo"

    # 사전순으로 앞서는 팰린드롬 만들기
    # 1. 앞부분 구성 (사전순으로 정렬한 문자들의 절반)
    front = ''
    for char in sorted(char_count.keys()):
        front += char * (char_count[char] // 2)

    # 2. 중앙에 홀수 빈도수 문자 배치
    mid = odd_char if odd_char else ''

    # 3. 뒷부분은 앞부분의 역순
    back = front[::-1]

    # 최종 팰린드롬
    return front + mid + back


# 입력 받기
name = input()

# 팰린드롬 만들기 및 결과 출력
print(make_palindrome(name))