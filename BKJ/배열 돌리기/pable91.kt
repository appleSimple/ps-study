/**
 *  배열 돌리기
 *  https://www.acmicpc.net/problem/17276
 *
 */

fun main() {
    val T = readLine()!!.toInt()
    repeat(T) {
        val (N, d) = readLine()!!.split(" ").map { it.toInt() }
        val board = Array(N) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() }
        var ans = Array(N) { IntArray(N) }

        var degree = d
        if (degree < 0) degree += 360

        if (degree == 0 || degree == 360) {
            board.forEach { row -> println(row.joinToString(" ")) }
        } else {
            var tempBoard = board
            repeat(degree / 45) {
                val mid = N / 2
                ans = Array(N) { IntArray(N) }

                for (i in 0 until N) {
                    for (j in 0 until N) {
                        if (j == mid) {
                            ans[i][j] = tempBoard[i][i] // 주대각선 → 가운데 열
                        } else if (i + j == N - 1) {
                            ans[i][j] = tempBoard[i][mid] // 가운데 열 → 부대각선
                        } else if (i == mid) {
                            ans[i][j] = tempBoard[N - j - 1][j] // 부대각선 → 가운데 행
                        } else if (i == j) {
                            ans[i][j] = tempBoard[mid][j] // 가운데 행 → 주대각선
                        } else {
                            ans[i][j] = tempBoard[i][j] // 나머지 그대로
                        }
                    }
                }
                tempBoard = ans.map { it.clone() }.toTypedArray()
            }
            ans.forEach { row -> println(row.joinToString(" ")) }
        }
    }
}