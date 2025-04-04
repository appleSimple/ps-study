import sys


def find_file(start_path):
    # 폴더 탐색을 위한 스택과 파일 집합, 파일 카운터 초기화
    stack = [start_path]
    file_list = set()  # 고유한 파일 목록
    num = 0  # 총 파일 개수

    while stack:
        # 현재 탐색 중인 폴더
        cur_path = stack.pop()

        # 현재 폴더의 모든 아이템 순회
        for item in dic.get(cur_path, []):
            # 아이템이 폴더라면 스택에 추가하여 더 깊이 탐색
            if item in dic:
                stack.append(item)
            # 아이템이 파일이라면 고유 파일 집합에 추가하고 총 파일 수 증가
            else:
                file_list.add(item)
                num += 1

    # 고유 파일 개수와 총 파일 개수 반환
    return len(file_list), num


# 입력 받기
# N: 폴더의 수, M: 파일의 수
N, M = map(int, sys.stdin.readline().split())

# 폴더 구조를 저장할 딕셔너리
dic = {}

# 폴더 구조 생성
for _ in range(N + M):
    # P: 상위 폴더, F: 파일/폴더 이름, C: 폴더/파일 구분 (1:폴더, 0:파일)
    P, F, C = sys.stdin.readline().split()

    # 상위 폴더가 딕셔너리에 없으면 빈 리스트로 초기화
    if P not in dic:
        dic[P] = []

    # 폴더일 경우 해당 폴더를 딕셔너리에 빈 리스트로 초기화
    if C == '1' and F not in dic:
        dic[F] = []

    # 상위 폴더의 하위 항목(파일 또는 폴더)으로 추가
    dic[P].append(F)

# 쿼리의 수 입력
Q = int(sys.stdin.readline())

# 각 쿼리 처리
for _ in range(Q):
    # 경로 입력 (마지막 폴더명만 사용)
    path = sys.stdin.readline().rstrip().split('/')

    # 마지막 폴더의 고유 파일 개수와 총 파일 개수 출력
    unique_files, total_files = find_file(path[-1])
    print(unique_files, total_files)