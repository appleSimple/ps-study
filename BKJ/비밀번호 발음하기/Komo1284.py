def has_vowel(text):
    """모음을 하나 이상 포함하는지 확인하는 함수"""
    return any(char in 'aeiou' for char in text)


def check_consecutive(text):
    """모음 또는 자음이 3개 연속으로 오는지 확인하는 함수"""
    vowels = set(['a', 'e', 'i', 'o', 'u'])
    vowel_count = 0
    consonant_count = 0

    for char in text:
        if char in vowels:
            vowel_count += 1
            consonant_count = 0
        else:
            consonant_count += 1
            vowel_count = 0

        if vowel_count >= 3 or consonant_count >= 3:
            return False

    return True


def check_double_letters(text):
    """같은 글자가 연속으로 두 번 오는지 확인하는 함수 (ee, oo 제외)"""
    for i in range(len(text) - 1):
        if text[i] == text[i + 1]:
            if text[i:i + 2] not in ['ee', 'oo']:
                return False
    return True


def is_acceptable(text):
    """단어가 모든 조건을 만족하는지 확인하는 함수"""
    if not has_vowel(text):
        return False
    if not check_consecutive(text):
        return False
    if not check_double_letters(text):
        return False
    return True


# 메인 실행 부분
while True:
    word = input()
    if word == "end":
        break

    result = "acceptable" if is_acceptable(word) else "not acceptable"
    print(f"<{word}> is {result}.")