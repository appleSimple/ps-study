import sys

# 스택을 구현할 빈 리스트 생성
stack = []

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
        # 두 번째 인자(숫자)를 스택에 추가
        stack.append(int(command[1]))

    # pop 명령어 처리
    elif op == 'pop':
        # 스택이 비어있으면 -1 출력, 아니면 마지막 요소 제거 후 출력
        if not stack:
            print(-1)
        else:
            print(stack.pop())

    # size 명령어 처리
    elif op == 'size':
        # 스택의 현재 크기 출력ㅇ
        print(len(stack))

    # empty 명령어 처리
    elif op == 'empty':
        # 스택이 비어있으면 1, 아니면 0 출력
        print(1 if not stack else 0)

    # top 명령어 처리
    elif op == 'top':
        # 스택이 비어있으면 -1, 아니면 마지막 요소 출력
        if not stack:
            print(-1)
        else:
            print(stack[-1])