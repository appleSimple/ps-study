# 입력 처리
n, m = map(int, input().split())
bulbs = list(map(int, input().split()))

# 각 명령 수행
for _ in range(m):
    command, a, b = map(int, input().split())

    if command == 1:
        # 1번 명령: i번째 전구의 상태를 x로 변경
        bulbs[a - 1] = b

    elif command == 2:
        # 2번 명령: l~r번째 전구 상태 반전
        for i in range(a - 1, b):
            bulbs[i] = 1 - bulbs[i]  # 0->1, 1->0으로 반전

    elif command == 3:
        # 3번 명령: l~r번째 전구를 끄기
        for i in range(a - 1, b):
            bulbs[i] = 0

    elif command == 4:
        # 4번 명령: l~r번째 전구를 켜기
        for i in range(a - 1, b):
            bulbs[i] = 1

# 결과 출력: 켜진 전구의 상태
print(' '.join(map(str, bulbs)))