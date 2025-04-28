def rotate_array(arr, n, m, r):
    # 회전할 수 있는 그룹(테두리) 수 계산
    # 행과 열 중 작은 값의 절반
    groups = min(n, m) // 2

    # r번 회전
    for _ in range(r):
        # 각 그룹(테두리)별로 회전
        for group in range(groups):
            # 현재 그룹의 경계 설정
            start_row, start_col = group, group
            end_row, end_col = n - 1 - group, m - 1 - group

            # 첫 원소 임시 저장
            temp = arr[start_row][start_col]

            # 위쪽 라인 왼쪽으로 이동
            for j in range(start_col, end_col):
                arr[start_row][j] = arr[start_row][j + 1]

            # 오른쪽 라인 위로 이동
            for i in range(start_row, end_row):
                arr[i][end_col] = arr[i + 1][end_col]

            # 아래쪽 라인 오른쪽으로 이동
            for j in range(end_col, start_col, -1):
                arr[end_row][j] = arr[end_row][j - 1]

            # 왼쪽 라인 아래로 이동
            for i in range(end_row, start_row, -1):
                arr[i][start_col] = arr[i - 1][start_col]

            # 첫 원소 마지막 위치에 배치
            arr[start_row + 1][start_col] = temp

    return arr


# 메인 로직
import sys

# 입력 받기
n, m, r = map(int, sys.stdin.readline().split())
arr = []
for _ in range(n):
    arr.append(list(map(int, sys.stdin.readline().split())))

# 배열 회전
rotated_arr = rotate_array(arr, n, m, r)

# 결과 출력
for row in rotated_arr:
    print(*row)