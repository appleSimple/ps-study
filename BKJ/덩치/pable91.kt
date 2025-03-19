/**
 *  덩치
 *  https://github.com/appleSimple/ps-study/issues/73
 *
 *  1. 숫자 N을 입력받는다. 그리고 N만큼 Pair를 저장하는 배열 arr 생성
 *  2. arr의 크기만큼 순회하면서 x,y 입력받아 초기화
 *  3. x의 내림차순으로 정렬한다
 *  4. arr 배열을 순회하면서 y를 비교한다,
 *  5. 만약 현재 y보다 높은 사람이 없으면 현재 등수를 체크하고 등수 하나 올리고 y+1부터 다시 순회
 *  6. 만약 현재 y보다 높은 사람이 있으면 현재 등수를 체크하고 y+1부터 다시 순회
 */

fun main() {

    val N = readln().toInt()

    val persons = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until N) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        persons.add(Pair(x, y))
    }

    persons.forEach { curPerson ->
        var countRank = 1
        persons.forEach { everyEachPerson ->
            if (curPerson.first < everyEachPerson.first &&
                curPerson.second < everyEachPerson.second
            ){
                countRank++
            }
        }
        println(countRank)
    }
}
