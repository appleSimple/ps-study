import sys
from collections import deque

# 큐 생성 (deque 사용)
queue = deque()

# 명령의 개수 입력받기
N = int(sys.stdin.readline().strip())

# N번 반복하며 명령 처리
for _ in range(N):
    # 명령어 입력받기
    command = sys.stdin.readline().strip().split()

    # 명령어의 첫 번째 단어 추출
    op = command[0]

    # push 명령어 처리
    if op == 'push':
        # 두 번째 인자(숫자)를 큐에 추가
        queue.append(int(command[1]))

    # pop 명령어 처리
    elif op == 'pop':
        # 큐가 비어있으면 -1 출력, 아니면 첫 번째 요소 제거 후 출력
        if not queue:
            print(-1)
        else:
            print(queue.popleft())

    # size 명령어 처리
    elif op == 'size':
        # 큐의 현재 크기 출력
        print(len(queue))

    # empty 명령어 처리
    elif op == 'empty':
        # 큐가 비어있으면 1, 아니면 0 출력
        print(1 if not queue else 0)

    # front 명령어 처리
    elif op == 'front':
        # 큐가 비어있으면 -1, 아니면 첫 번째 요소 출력
        if not queue:
            print(-1)
        else:
            print(queue[0])

    # back 명령어 처리
    elif op == 'back':
        # 큐가 비어있으면 -1, 아니면 마지막 요소 출력
        if not queue:
            print(-1)
        else:
            print(queue[-1])