/**
 * 배열 돌리기
 * https://www.acmicpc.net/problem/16926
 *
 * - 배열크기 N,M을 입력한다. N이 y, M이 x다.
 * - 그리고 회전수 R을 입력한다
 * - N,M만큼 배열을 만들어서, 입력받는다.
 * - 가장 바깥쪽 사각형부터 이동을 해야하기때문에 시작점은 (0,0) 순으로 이동한다.
 * - 바깥쪽 사각형을 회전수 R만큼 이동하고 그다음은 안쪽에 있는 사각형으로 이동한다 (1,1)
 * - 요소 한개 이동할떄 마다 임시 tmp에 놓고, 다음 요소를 이동하는 방식을 사용한다
 * - 왼쪽, 오른쪽, 아래, 위 4방향을 나눠서 움직인다.
 */

fun main() {
    val (N, M, R) = readLine()!!.split(" ").map { it.toInt() }
    val arr = Array(N) { readLine()!!.split(" ").map { it.toInt() }.toTypedArray() }

    val layers = minOf(N, M) / 2

    repeat(R) {
        val temp = Array(N) { arr[it].clone() }

        for (layer in 0 until layers) {
            val startY = layer
            val startX = layer
            val endY = N - layer - 1
            val endX = M - layer - 1

            // 왼쪽 → 아래 (↓)
            for (y in startY + 1 until endY + 1) {
                temp[y][startX] = arr[y - 1][startX]
            }

            // 아래 → 오른쪽 (→)
            for (x in startX + 1 until endX + 1) {
                temp[endY][x] = arr[endY][x - 1]
            }

            // 오른쪽 → 위 (↑)
            for (y in startY until endY) {
                temp[y][endX] = arr[y + 1][endX]
            }

            // 위 → 왼쪽 (←)
            for (x in startX until endX) {
                temp[startY][x] = arr[startY][x + 1]
            }
        }

        // 회전 결과 적용
        for (i in 0 until N) {
            for (j in 0 until M) {
                arr[i][j] = temp[i][j]
            }
        }
    }

    arr.forEach {
        println(it.joinToString(" "))
    }
}