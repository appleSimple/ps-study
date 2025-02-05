# 테스트 케이스 개수 입력받기
print("테스트 수를 입력해주세요. (1~20) : ")
T = int(input())

# 각 테스트 케이스별 결과를 저장할 리스트
results = []

# T번 만큼 반복
for i in range(T):
    print(i+1, "번째 문자열을 입력해주세요 : ")
    # 문자열 입력받기
    text = input()

    # 문자 빈도수를 저장할 딕셔너리
    char_count = {}

    # 문자열의 각 문자를 순회하면서 빈도수 계산
    for char in text:
        # 공백은 제외
        if char != ' ':
            # get() 메서드를 사용하여 기존 값이 없으면 0을 반환하고 1을 더함
            char_count[char] = char_count.get(char, 0) + 1

    # 가장 높은 빈도수 찾기
    max_count = max(char_count.values())

    # 최대 빈도수를 가진 문자들 찾기
    max_chars = [char for char, count in char_count.items() if count == max_count]

    # 최대 빈도수를 가진 문자가 1개인 경우 해당 문자 출력, 아니면 ? 출력
    result = max_chars[0] if len(max_chars) == 1 else '?'
    results.append(result)

# 결과 출력
for result in results:
    print(result)