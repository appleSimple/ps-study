/**
 *  한 줄로 서기
 *  https://www.acmicpc.net/problem/1138
 *
 */

fun main() {

    val N = readln().toInt()
    val inputs = readln().split(" ").map { it.toInt() }

    val arr = IntArray(N)
    for (i in 0 until inputs.size) {
        val n = inputs[i]
        var cnt = 0
        for (j in 0 until inputs.size) {
            if(cnt == n && arr[j] == 0) {
                arr[j] = i + 1
                break
            }
            if(arr[j] == 0 || arr[j] > i+1) {
                cnt += 1
            }
        }
    }

    for (elem in arr) {
        print("$elem ")
    }

}