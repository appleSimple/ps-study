import sys


def sort_words(N, M, words):
    # M보다 짧은 단어 필터링
    filtered_words = [word for word in words if len(word) >= M]

    # 단어 빈도수 계산
    word_count = {}
    for word in filtered_words:
        word_count[word] = word_count.get(word, 0) + 1

    # 다중 조건 정렬
    sorted_words = sorted(word_count.keys(),
                          key=lambda x: (-word_count[x], -len(x), x))

    return sorted_words


# 빠른 입력 처리
N, M = map(int, sys.stdin.readline().split())
words = [sys.stdin.readline().rstrip() for _ in range(N)]

# 결과 출력
result = sort_words(N, M, words)
for word in result:
    print(word)