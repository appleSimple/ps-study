/**
 *  못품 ㅠ.ㅠ
 */
/**
 *  크로스 컨트리
 *  https://www.acmicpc.net/problem/9017
 *
 *  1. 게임 횟수를 나타내는 T 입력
 *  2. T를 순회하며 선수들 N을 입력
 *  3. N을 순회하며 팀 숫자 입력(순서대로 등수임)
 *  4. <Key,Triple<현재 들어온 선수 숫자, 현재 점수, 5번째 선수 점수> 이라는 Map을 선언한다
 *  5. 등수를 계산할때마다 현재 팀들을 순회하면서 현재 들어온 선수 숫자를 파악해서 4라면,다음 선수는 5섯번째이기때문에 따로 저장
 *  6. 최종 팀별로 점수를 계산해서, 6명이 아닌 팀들은 제외
 *  7. 참여 숫자가 6명이고 팀별로 점수를 계산해서 낮은 팀이 우승하지만, 만약 동점이 나오면 5번째 선수를 다시 더한다. 그리고 우승팀 뽑기
 */

fun main() {

    val T = readln().toInt()

    val scoresList = MutableList(T) { mutableListOf<Int>() } // 빈 리스트로 초기화

    for (i in 0 until T) {
        val N = readln().toInt()
        scoresList[i].addAll(readln().split(" ").map { it.toInt() })
    }

    for (i in 0 until scoresList.size) {

        val frequentElementsList = mutableListOf<Map<Int, Int>>()// 선수인원이 6이 아닌 팀 번호를 저장할 리스트

        for (list in scoresList) {
            val frequencyMap = list.groupingBy { it }.eachCount() // 선수 인원 구하기
            val frequentElements = frequencyMap.filter { it.value != 6 }  // 선수가 6명이 아닌 팀 필터링

            frequentElementsList.add(frequentElements)
        }

        val teamsInfoMap = mutableMapOf<Int, Triple<Int, Int, Int>>()

        var point = 0
        for (j in 0 until scoresList[i].size) {
            val teamNum = scoresList[i][j]
            val teamInfo = teamsInfoMap.getOrDefault(teamNum, Triple(0, 0, 0))
            if (frequentElementsList.flatMap { it.keys }.contains(teamNum)) {
                continue
            }


            point += 1

            if (teamInfo.first == 4) {
                teamsInfoMap.put(teamNum, Triple(teamInfo.first + 1, teamInfo.second + point, teamInfo.third + j + 1))
            } else if (teamInfo.first < 4) {
                teamsInfoMap.put(teamNum, Triple(teamInfo.first + 1, teamInfo.second + point, teamInfo.third))
            } else {
                teamsInfoMap.put(teamNum, Triple(teamInfo.first + 1, teamInfo.second, teamInfo.third))
            }
        }

        var minKey: Int? = null
        var minValue: Int? = null

        for ((key, value) in teamsInfoMap) {
            val (first, second, third) = value

            if (first != 6) continue

            // 실제 비교할 값 (second + third)
            val compareValue = second + third

            // 최소값을 찾는 로직
            if (minValue == null || compareValue < minValue) {
                minValue = compareValue
                minKey = key
            }
        }

        println("$minKey") // 최종 결과 출력
    }
}