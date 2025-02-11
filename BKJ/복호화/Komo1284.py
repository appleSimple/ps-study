print("테스트 수를 입력해주세요. (1~20) : ")
T = int(input())
results = []

for i in range(T):
    print(i+1, "번째 문자열을 입력해주세요 : ")
    text = input()

    char_count = {}

    for char in text:
        if char != ' ':
           char_count[char] = char_count.get(char, 0) + 1

    max_count = max(char_count.values())

    max_chars = [char for char, count in char_count.items() if count == max_count]

    result = max_chars[0] if len(max_chars) == 1 else '?'
    results.append(result)

for result in results:
    print(result)