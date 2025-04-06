import sys

N, M = map(int, sys.stdin.readline().strip().split())
dic = dict()

def find_file(start_path):
    global num
    stack = [start_path]
    while stack:
        cur_path = stack.pop()
        for i in dic.get(cur_path):
            if i in dic:
                stack.append(i)
            if i not in dic:
                file_list.add(i)
                num += 1
    return

for i in range(N + M):
    P, F, C = map(str, sys.stdin.readline().split())
    if P not in dic:
        dic[P] = []
    if C=='1' and F not in dic:
        dic[F] = []

    dic[P].append(F)

Q = int(sys.stdin.readline())

for i in range(Q):
    visited = []
    file_list = set()
    num = 0
    path = list(map(str, sys.stdin.readline().rstrip().split('/')))
    find_file(path[-1])
    print(len(file_list), num)