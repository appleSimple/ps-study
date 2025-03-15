/**
 * 기상 캐스터
 * https://github.com/appleSimple/ps-study/issues/74
 *
 * 1. H, W를 입력한다
 * 2. H x W 배열을 만들어서 . 또는 C를 입력한다
 * 3. 행열을 순회하면서 c가 있으면 0으로 바꾼다,
 * 4. c가 나올때마다 인덱스를 저장해서 .이 나오는 인덱스에서 c의 인덱스를 차를 구한다.
 *
 */

fun main() {

    val (H, W) = readln().split(" ").map { it.toInt() }
    val arr = Array(H) { IntArray(W) }

    for (i in 0 until H) {
        val toCharArray = readln().toCharArray()
        var cIdx = -1

        for (j in 0 until W) {
            if (toCharArray[j] == 'c') {
                arr[i][j] = 0
                cIdx = j
            } else if (toCharArray[j] == '.') {
                if (cIdx == -1) {
                    arr[i][j] = -1
                } else {
                    arr[i][j] = j - cIdx
                }
            }
        }
    }


    for (row in arr) {
        println(row.joinToString(" "))
    }
}
