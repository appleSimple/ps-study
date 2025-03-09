/**
 * 소가 길을 건너간 이유 1
 * https://www.acmicpc.net/problem/14467
 *
 * 1. 입력받은 정수만큼 for문으로 입력
 * 2. 소들의 위치를 기억할 배열 선언
 * 3. 소돌의 위치 이동 횟수를 기억할 배열 선언
 * 4. 이전 위치와 다르면 위치 이동 횟수 배열에서 +1 한다
 * 5. 소들의 위치 이동 횟수 배열을 모두 sum 한다
 *
 */

fun main() {

    val input = readln().toInt()
    val arr = IntArray(100) {-1}
    val cowMoveCount = IntArray(100) {0}
    for (i in 0 until input) {
        val pairs = readLine()!!.split(" ")
            .map { it.toInt() }

        if(arr[pairs.first()] == -1) {
            cowMoveCount[pairs.first()] = 0
        }
        else if (arr[pairs.first()] != pairs.last()) {
            cowMoveCount[pairs.first()] += 1
        }
        arr[pairs.first()] = pairs.last()
    }

    var result = 0;
    for (elem in cowMoveCount) {
        result += elem;
    }
    print(result);
}