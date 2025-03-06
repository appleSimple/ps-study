/**
 * 단어 뒤집기2
 * https://www.acmicpc.net/problem/17413
 *
 * 배운 내용
 * 1. 코틀린 when
 * 2. 문자열에 문자를 더할거면 StringBuilder()를 쓰자
 */

fun main() {
    val input = readln()

    var tmp = StringBuilder()
    var result = StringBuilder()
    var flag1 = false;
    var flag2 = false;
    for (elem in input) {
        when {
            elem == ' ' -> {
                if (flag2) {
                    result.append(tmp.append(elem))
                } else {
                    result.append(tmp.reverse()).append(elem)
                }
                tmp.clear()
                flag1 = true
            }
            elem == '<' -> {
                    result.append(tmp.reverse()).append(elem)
                    tmp.clear()
                    flag1 = true
                    flag2 = true;
                }
            elem == '>' -> {
                result.append(tmp.append(elem))
                tmp.clear()
                flag2 = false
            }
            else -> {
                tmp.append(elem)
            }
        }
    }

    if(!flag1) {
        result.append(input.reversed())
    } else {
        result.append(tmp.reversed())
    }

    println(result)
}