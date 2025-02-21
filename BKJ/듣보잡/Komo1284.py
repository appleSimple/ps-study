n, m = map(int, input().split())

N = set()  # 리스트 대신 set 사용
M = set()  # 리스트 대신 set 사용

for _ in range(n):
    N.add(input())

for _ in range(m):
    M.add(input())

result = sorted(N & M)  # 교집합 후 정렬

print(len(result))
for name in result:
    print(name)