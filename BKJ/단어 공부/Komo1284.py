s = input().upper()
s1 = list(set(s))
len_list = []

for i in s1:
    cnt = s.count(i)
    len_list.append(cnt)

if len_list.count(max(len_list)) > 1:
    print("?")
else :
    max_index = len_list.index(max(len_list))
    print(s1[max_index])