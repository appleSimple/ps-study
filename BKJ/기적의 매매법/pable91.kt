/**
 *  기적의 매매법
 *  https://www.acmicpc.net/problem/20546
 *
 *  1. 현금 MONEY 입력받기
 *  2. 14개의 주가 배열 prices 로 입력받기
 *  3. 준현, 성민 주식 수 및 갖고 있는 현금을 표현하는 Pair 객체를 2개 선언하기
 *  4. 준현이는 14개 주가를 순회하면서 현금/주가 나눈 뒤, 몫을 주식 수 나머지는 현재 현금으로 치환한다
 *  5. 성민이는 14개 주가를 순회하면서 3일 연속 상승한다면 그 다음날 주식을 매수하고, 3일 연속 하락한다면 그 다음날 주식을 매도한다. 동일하면 상승 및 하락이 아니다
 *  6. 최종으로 현금 * 주가 * 주식수를 곱해서 결과를 낸다
 *  7. 준현이 이기면 BNP, 성민이 이기면 TIMING, 비기면 SAMESAME
 */

fun main() {

    val money = readln().toInt()
    val prices = readln().split(" ").map { it.toInt() }
    val player1 = mutableListOf(money, 0)
    val player2 = mutableListOf(money, 0)

    var prev = 0
    var upCnt = 1
    var downCnt = 1
    for (i in 0 until prices.size - 1) {
        if (player1[0] / prices[i] >= 1 ) {
            player1[1] += (player1[0] / prices[i])
            player1[0] = (player1[0] % prices[i])
        }

        if(downCnt == 3) {
            downCnt = 1
            upCnt = 1
            if (player2[0] / prices[i] > 1 ) {
                player2[1] += (player2[0] / prices[i])
                player2[0] = (player2[0] % prices[i])
            }
        }
        else if (upCnt == 3) {
            upCnt = 1
            downCnt = 1
            if (player2[1] >= 1) {
                player2[0] += (player2[1] * prices[i])
                player2[1] = 0
            }
        }

        if(i == 0) {
            prev = prices[i]
        }
        else {
            if (prev > prices[i]) {
                downCnt += 1
                upCnt = 1
            }
            else if(prev < prices[i]) {
                upCnt += 1
                downCnt = 1
            }
            prev = prices[i]
        }


    }

    val result1 = player1[0] + (player1[1] * prices[prices.size - 1])
    val result2 = player2[0] + (player2[1] * prices[prices.size - 1])

    if(result1 > result2) {
        print("BNP")
    }
    else if(result1 < result2) {
        print("TIMING")
    }
    else {
        print("SAMESAME")
    }
}