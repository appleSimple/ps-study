def trap_rain(h, w, heights):
    total_water = 0

    # 각 위치별로 계산
    for i in range(1, w - 1):  # 맨 왼쪽과 맨 오른쪽은 물이 고일 수 없음
        # 현재 위치 기준 왼쪽 최대 높이
        left_max = max(heights[:i])

        # 현재 위치 기준 오른쪽 최대 높이
        right_max = max(heights[i + 1:])

        # 현재 위치에 고일 수 있는 물의 양 계산
        water_level = min(left_max, right_max)

        # 물이 고일 수 있으면 추가
        if water_level > heights[i]:
            total_water += water_level - heights[i]

    return total_water


# 입력 받기
h, w = map(int, input().split())
heights = list(map(int, input().split()))

# 결과 출력
print(trap_rain(h, w, heights))