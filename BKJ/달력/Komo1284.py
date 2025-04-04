n = int(input())
calendar = {}

# 일정 입력 및 겹침 횟수 계산
for _ in range(n):
    s, e = map(int, input().split())
    for day in range(s, e + 1):
        calendar[day] = calendar.get(day, 0) + 1

# 면적 계산
total_area = 0
current_width = 0
current_height = 0

# 실제 입력된 날짜의 최소, 최대 범위만 순회
for day in range(min(calendar.keys()), max(calendar.keys()) + 1):
    if day in calendar:
        # 연속된 일정이 있는 경우
        current_width += 1
        current_height = max(current_height, calendar[day])
    else:
        # 일정이 없는 날 발견 - 면적 계산
        total_area += current_width * current_height
        # 초기화
        current_width = 0
        current_height = 0

# 마지막 연속 구간 처리
total_area += current_width * current_height

print(total_area)