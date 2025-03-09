/**
 * 전구
 * https://www.acmicpc.net/problem/21918
 *
 * 1. 전구의 갯수 N과 명령어 갯수 M을 입력받는다
 * 2. N개 길이의 배열을 만든다.
 * 3. 전구의 상태를 N개만큼 입력받아 초기화한다. true가 켜져있음, false는 꺼져있음
 * 4. 그리고 M개만큼 순회하면서  a,b,c를 입력받는다.
 * 5. 전구 b부터 c를 명령어 a로 수행한다
 *
 * 배운점
 * 1. 배열을 map으로 통해 변환하는 방법?
 * 2. Triple이 있구나
 */

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }

    val lights = BooleanArray(N) {false}

    val input = readln().split(" ").map { it.toInt() == 1 }

    for (i in 0 until N) {
        lights[i] = input[i]
    }

    val commands = mutableListOf<Triple<Int, Int, Int>>()
    for (i in 0 until M) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        commands.add(Triple(a, b, c))
    }

    for (cmd in commands) {
        val start = cmd.second
        val end = cmd.third

        if(cmd.first == 1) {
            lights[start-1] = (end == 1)
        }
        else if(cmd.first == 2) {
            for (i in start-1..< end) {
                lights[i] = !lights[i]
            }
        }
        else if(cmd.first == 3) {
            for (i in start-1..< end) {
                lights[i] = false
            }
        }
        else if(cmd.first == 4) {
            for (i in start-1..< end) {
                lights[i] = true
            }
        }
    }

    println(lights.joinToString(" ") { if (it) "1" else "0" })

}