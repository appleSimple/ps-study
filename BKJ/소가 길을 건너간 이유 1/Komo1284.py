n = int(input())
cow_positions = {}  # 각 소의 현재 위치를 저장할 딕셔너리
crossings = 0  # 길을 건넌 총 횟수

for _ in range(n):
    cow_id, position = map(int, input().split())  # 소의 번호와 위치 입력

    # 이미 관찰된 소이고, 위치가 바뀌었다면 길을 건넌 것으로 간주
    if cow_id in cow_positions and cow_positions[cow_id] != position:
        crossings += 1

    # 현재 소의 위치 업데이트
    cow_positions[cow_id] = position

print(crossings)  # 결과 출력