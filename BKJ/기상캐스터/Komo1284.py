# 입력
# 입력은 1 + H 행으로 주어진다.
# 첫 번째 행에는 정수 H, W (1 ≦ H ≦ 100, 1 ≦ W ≦ 100) 가 공백을 사이에 주고 주어진다.
# 이것은 JOI시가 H × W 개의 작은 구역으로 나뉘어 있다는 것을 의미한다.
#
# 이어진 H 개의 행의 i번째 행 (1 ≦ i ≦ H) 에는 W문자의 문자열이 주어진다.
# W 개의 문자 중 j번째 문자 (1 ≦ j ≦ W) 는, 구역 (i, j) 에 지금 구름이 떠 있는지 아닌지를 나타낸다.
# 구름이 있는 경우에는 영어 소문자 'c' 가, 구름이 없는 경우에는 문자 '.' 가 주어진다.

# 출력
# 출력은 H 행으로, 각 행에는 공백으로 구분된 W 개의 정수를 출력한다.
# 출력의 i 번째 행 j 번째 정수 (1 ≦ i ≦ H, 1 ≦ j ≦ W) 는, 지금부터 몇 분후에 처음으로 구역 (i, j) 에 구름이 뜨는지를 표시한다.
# 단, 처음부터 구역 (i, j) 에 구름이 떠 있었던 경우에는 0을, 몇 분이 지나도 구름이 뜨지 않을 경우에는 -1을 출력한다.

h, w = map(int, input().split())
grid = []

# 입력 받기
for _ in range(h):
    grid.append(input())

# 각 행 처리
for i in range(h):
    row_result = []

    for j in range(w):
        if grid[i][j] == 'c':
            # 현재 위치에 구름이 있음
            row_result.append(0)
        else:
            # 왼쪽에서 가장 가까운 구름 찾기
            found_cloud = False
            for k in range(j - 1, -1, -1):
                if grid[i][k] == 'c':
                    # 구름 찾음, 도착 시간 계산
                    row_result.append(j - k)
                    found_cloud = True
                    break

            if not found_cloud:
                # 왼쪽에 구름이 없음, 구름이 절대 도착하지 않음
                row_result.append(-1)

    # 결과 출력
    print(*row_result)
