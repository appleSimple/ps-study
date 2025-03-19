# 입력 - 첫 줄에는 전체 사람의 수 N이 주어진다. 그리고 이어지는 N개의 줄에는 각 사람의 몸무게와 키를 나타내는 양의 정수 x와 y가 하나의 공백을 두고 각각 나타난다.
# 출력 - 여러분은 입력에 나열된 사람의 덩치 등수를 구해서 그 순서대로 첫 줄에 출력해야 한다. 단, 각 덩치 등수는 공백문자로 분리되어야 한다.

# 사람들의 정보를 담을 리스트
people = []
for i in range(int(input())):
    kg, cm = map(int, input().split())
    people.append((kg, cm))

# 각 사람의 덩치 등수를 저장할 리스트
ranks = []
# 각 사람마다 다른 모든 사람과 비교
for i in range(len(people)):
    # 자신보다 덩치가 큰 사람의 수
    larger_count = 0

    for j in range(len(people)):
        # 자기 자신은 건너뛰기
        if i == j:
            continue

        # 다른 사람의 몸무게와 키가 모두 크면 larger_count 증가
        if people[j][0] > people[i][0] and people[j][1] > people[i][1]:
            larger_count += 1

    # 덩치 등수는 자신보다 덩치가 큰 사람의 수 + 1
    ranks.append(larger_count + 1)

# 띄어쓰기를 기준으로 출력
for i in range(len(ranks)):
    print(ranks[i], end=' ')