/**
 *  NBA 농구
 *  https://www.acmicpc.net/problem/2852
 *
 *  1. 골이 들어간 횟수 N 입력
 *  2. triple <점수, 카운팅 시작 시간, 이기고 있는 시간> 선언
 *  3. N만큼 순회하면서, 골 넣으면 점수 더하기, 그리고 점수 비교해서
 *      - 이겼으면 시작 시간 세팅(=카운팅 시작)
 *      - 비겼으면 이기고 있던 팀의 이기고 있는 시간 적용
 *  4. 팀이 계속 이기는 경우도 생각해야함. (=이런 케이스에선 카운팅 시작 시간을 어떻게 처리할 것인가?)
 *  5. 문자열 <=> 정수로 변환하는 유틸 메소드 필요함
 */

fun timeStringToSeconds(time: String): Int {
    val (hour, minute) = time.split(":").map { it.toInt() }
    return hour * 3600 + minute * 60
}

fun secondsToTimeString(seconds: Int): String {
    val hours = seconds / 3600
    val minutes = (seconds % 3600) / 60
    return "%02d:%02d".format(hours, minutes)
}

fun main() {

    val N = readln().toInt()
    var team1 = Triple(0,0,0)
    var team2 = Triple(0,0,0)

    for (i in 0 until N) {
        val list = readln().split(" ").map { it }
        var flag = false
        if (list.get(0).equals("1")) {
            if(team1.first > team2.first) {
                flag = true
            }
            team1 = team1.copy(first = team1.first + 1)
            if (team1.first > team2.first) {
                if(flag == false) {
                    val now = list.get(1)
                    team1 = team1.copy(second = timeStringToSeconds(now))
                }
            }
            else if (team1.first == team2.first) {
                team2 = team2.copy(third = team2.third + (timeStringToSeconds(list.get(1)) - team2.second))
            }
        }
        else if (list.get(0).equals("2")) {
            if(team1.first < team2.first) {
                flag = true
            }
            team2 = team2.copy(first = team2.first + 1)
            if (team1.first < team2.first) {
                if(flag == false) {
                    val now = list.get(1)
                    team2 = team2.copy(second = timeStringToSeconds(now))
                }
            }
            else if (team1.first == team2.first) {
                team1 = team1.copy(third = team1.third + (timeStringToSeconds(list.get(1)) - team1.second))
            }
        }
    }

    val final = timeStringToSeconds("48:00")
    if (team1.first > team2.first) {
        team1 = team1.copy(third = team1.third + (final - team1.second))
    }
    else if (team1.first < team2.first) {
        team2 = team2.copy(third = team2.third +(final - team2.second))
    }

    println(secondsToTimeString(team1.third))
    println(secondsToTimeString(team2.third))
}