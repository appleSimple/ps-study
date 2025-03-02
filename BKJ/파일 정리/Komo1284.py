# 파일 개수 N 입력받기
N = int(input())

# 확장자별 개수를 저장할 딕셔너리 생성
extension_count = {}

# N개의 파일 이름 입력받고 확장자 추출하기
for _ in range(N):
    filename = input()
    # 파일명에서 마지막 점(.) 이후의 문자열이 확장자
    extension = filename.split('.')[-1]

    # 확장자 개수 카운트
    if extension in extension_count:
        extension_count[extension] += 1
    else:
        extension_count[extension] = 1

# 확장자를 사전순으로 정렬
sorted_extensions = sorted(extension_count.keys())

# 정렬된 순서대로 확장자와 개수 출력
for ext in sorted_extensions:
    print(f"{ext} {extension_count[ext]}")