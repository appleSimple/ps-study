# 포켓몬 도감에 넣을 숫자(n)와 문제의 개수(m)
n, m = map(int, input().split())


# 포켓몬 도감
pokemonList = []

# 도감에 넣을 만큼 반복
for _ in range(n):
    pokemon = input()
    pokemonList.append(pokemon)

# 문제
for _ in range(m):
    ques = input()
    if ques.isdigit():
        print(pokemonList[int(ques) - 1])
    else:
        print(pokemonList.index(ques) + 1)