from collections import deque

N = int(input())
queue = deque(range(1, N+1))

while len(queue) > 1:
    queue.popleft()  # 맨 앞의 카드 버리기
    queue.append(queue.popleft())  # 그 다음 카드를 맨 뒤로 이동

print(queue[0])