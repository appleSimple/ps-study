# 듣보잡
# 1. map 은 반복가능한 객체에 함수(lambda, int)를 활용가능
# 2. 반복 불가능한 타입(int 정수)을 순회하려면 range 키워드를 써야함
# 3. {}는 set, []는 리스트, ()는 튜플
# 4. & 는 두 집합간의 교집합을 구할 때 사용


a, b = map(int, input().split())

arr1 = {input() for _ in range(a)}
arr2 = {input() for _ in range(b)}

result = sorted(arr1 & arr2)

print(len(result))

for elem in result:
  print(elem)










