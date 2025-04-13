/**
 *  빗물
 *  https://www.acmicpc.net/problem/14719
 *
 *  - 새로 H, W를 입력받아서 2차원 배열을 입력받는다
 *  - W만큼 비가 온 수를 입력받는다.
 *  - 그리고 비가 온 양만큼 차례대로 H의 end부터 --로 채워나간다
 *  - 다시 2차원 배열을 순회한다.
 *      - 순회하면서 비가 오지 않은 요소라면 왼쪽,오른쪽 끝까지 순회하면서 비가 왔는지 확인한다
 *      - 왼쪽, 오른쪽 둘 다 비가 왔다면 비가 고인 양(cnt)를 +1한다. 없다면 continue
 */

fun main() {

    var (H, W) = readLine()!!.split(" ").map { it.toInt() }
    val arr = Array(H) { Array(W) { false } }

    val rainCnts = readLine()!!.split(" ").map { it.toInt() }.toMutableList()
    for (i in 0 until rainCnts.size) {
        var h = H
        while (rainCnts[i] > 0) {
            arr[h - 1][i] = true
            h -= 1;
            rainCnts[i] -= 1
        }
    }

    var result = 0
    for (y in 0 until H) {
        for (x in 0 until W) {
            if (arr[y][x] == false) {
                var leftFlag = false
                var rightFlag = false

                // 왼쪽으로 확인
                for (i in x - 1 downTo 0) {
                    if (arr[y][i] == true) {
                        leftFlag = true
                        break
                    }
                }

                // 오른쪽으로 확인
                for (i in x + 1 until W) {
                    if (arr[y][i] == true) {
                        rightFlag = true
                        break
                    }
                }

                if (leftFlag && rightFlag)
                    result += 1
            }
        }
    }

    println(result)
}