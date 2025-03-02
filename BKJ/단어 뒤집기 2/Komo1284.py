def reverse_words_with_tags(s):
    i = 0
    result = []
    temp = []
    in_tag = False

    while i < len(s):
        # 태그 시작
        if s[i] == '<':
            # 지금까지 모인 단어를 뒤집어서 결과에 추가
            if temp:
                result.append(''.join(temp[::-1]))
                temp = []

            in_tag = True
            result.append('<')
        # 태그 종료
        elif s[i] == '>':
            in_tag = False
            result.append('>')
        # 태그 내부 문자는 그대로 추가
        elif in_tag:
            result.append(s[i])
        # 콤마나 공백은 구분자로 처리
        elif s[i] == ',' or s[i] == ' ':
            # 지금까지 모인 단어를 뒤집어서 결과에 추가
            if temp:
                result.append(''.join(temp[::-1]))
                temp = []
            result.append(s[i])
        # 일반 문자는 단어의 일부로 추가
        else:
            temp.append(s[i])

        i += 1

    # 마지막 단어가 있으면 추가
    if temp:
        result.append(''.join(temp[::-1]))

    return ''.join(result)


# 입력 받기
s = input()
print(reverse_words_with_tags(s))