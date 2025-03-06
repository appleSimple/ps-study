/**
 *  파일 정리
 *  https://www.acmicpc.net/problem/20291
 *
 *  1. 정수만큼 문자열 배열 만들고, for문 돌면서 입력받기
 *  2. Map (문자열, 정수) 로 만들기
 *  3. 문자열 배열 순회하면서, 확장자를 키로 두고 value는 카운트
 *  4. 정렬하기
 *
 *  배운것
 *   - 수정 가능한 콜렉션 list, map 선언하는 법
 *   - index 기반 for 문 수행하는것
 */

fun main() {

    val inputCnt = readln();
    var list = mutableListOf<String>();
    var map = mutableMapOf<String, Int>();
    val toInt = inputCnt.toInt();

    for(i in 0 until toInt)
        list.add(readln())

    for(elem in list) {
        val key = elem.substringAfter(".")
        map[key] = (map[key] ?: 0) + 1  // 기존 값이 있으면 +1, 없으면 1
    }

    // key 기준 오름차순 정렬된 맵 생성
    val sortedMap = map.toSortedMap()

    // 정렬된 결과 출력
    for ((key, value) in sortedMap) {
        println("$key $value")
    }
}