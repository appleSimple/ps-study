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