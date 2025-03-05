/**
 *  팰린드롬 만들기
 *  https://www.acmicpc.net/problem/1213
 *
 *  1. 입력받은 문자열을 순회해서 문자 갯수를 배열(arr)에 ++ 한다. 이때 유니코드값을 사용해서 배열에 순서대로 넣는다
 *  2. 배열(arr)을 순회해서 만약 홀수인 알파벳이 2개 이상이면 I'm Sorry Hansoo 리턴
 *  3. 배열(arr)이 모두 짝수면 순회하면서 갯수/2 만큼 정답문자열(result)에 더하고, 마지막에 reversed
 *  4. 배열(arr)에 홀수가 1개 있다면
 *       1) 해당 홀수 인덱스를 기억해놓고
 *       2) 배열 순회하면서 갯수/2 만큼 정답문자열(result)에 더하고
 *       3) 1)에서 구한 홀수 인덱스를 활용해서 문자를 정답문자열에 더하고
 *       4) 마지막으로 정답문자열 reversed 해서 다시 정답문자열에 더하기
 */

fun main() {
    val str = readln()
    val arr = IntArray(26) { 0 };
    var result = "";
    var cnt = 0;

    for (elem in str) {
        arr[elem.code - 65] += 1;
    }

    val oddCount = arr.count { it % 2 != 0 }

    if (oddCount >= 2) {
        print("I'm Sorry Hansoo")
        return
    }

    var oddIndex = 0;


    if (oddCount == 1) {
        arr.forEachIndexed { index, elem ->
            if ((elem >= 2)) {
                cnt = elem / 2;
                for (i in 0 until cnt) {
                    result += (65 + index).toChar();
                }
            }

            if (elem % 2 == 1) {
                oddIndex = index;
            }
        }

        val reserved = result.reversed();
        result += (65 + oddIndex).toChar();
        result += reserved;
    } else {
        arr.forEachIndexed { index, elem ->
            if ((elem % 2 == 0) && (elem >= 2)) {
                cnt = elem / 2;
                for (i in 0 until cnt) {
                    result += (65 + index).toChar();
                }
            }
        }

        val reserved = result.reversed();
        result += reserved;
    }

    println(result)
}

