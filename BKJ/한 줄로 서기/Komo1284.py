def solve(left_taller_counts):
    n = len(left_taller_counts)
    result = [0] * n

    # 키가 1부터 n까지인 사람들을 배치
    for height in range(1, n + 1):
        # 해당 키의 사람 앞에 와야 할 키 큰 사람 수
        count = left_taller_counts[height - 1]

        # 알맞은 위치 찾기
        position = 0
        while count > 0 or result[position] != 0:
            if result[position] == 0:
                count -= 1
            position += 1

        # 위치에 배치
        result[position] = height

    return result


# 입력 처리
n = int(input())
left_taller_counts = list(map(int, input().split()))
answer = solve(left_taller_counts)
print(' '.join(map(str, answer)))