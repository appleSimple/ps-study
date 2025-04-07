/**
 *  달팽이
 *  https://www.acmicpc.net/problem/1913
 *
 *  1. N 입력받기
 *  2. NxN 배열 선언, 0으로 초기화
 *  3. 배열을 돌면서 숫자 -1 하면서 값을 초기화한다. 처음 숫자는 N x N 값
 *  4. 케이스는 총 4개다. 아래 순서대로 반복하여 진행한다. 1이 나오면 초기화 종료
 *     - 아래로 내려갈때(y += 1)
 *          - 아래로 가다가 오른쪽으로 회전하는 조건은 y+1 = N 경우 또는 arr[y+1][x]이 원소값이 0 이 아닌경우
 *     - 오른쪽으로 갈때(x += 1)
 *          - 오른쪽으로 가다가 위로 회전하는 조건은 x+1 = N 경우 또는 arr[y][x+1]이 원소값이 0 이 아닌경우
 *     - 위로 갈때(y -= 1)
 *          - 위로 가다가 왼쪽 회전하는 조건은 y-1 = -1 경우 또는 arr[y-1][x]이 원소값이 0 이 아닌경우
 *     - 왼쪽으로 갈때(x -= 1)
 *          - 왼쪽 가다가 아래 회전하는 조건은 x-1 = -1 경우 또는 arr[y][x-1]이 원소값이 0 이 아닌경우
 *  5. NxN 배열을 순회하면서 출력, 동시에 찾는 자연수의 위치값을 구한다.
 *
 *  배운점
 *  - 이차원 배열 선언하는 방법
 */

fun main() {
    val N = readln().toInt()
    val target = readln().toInt()

    val matrix = Array(N) { IntArray(N) {0} }

    var x = 0
    var y = 0
    var num = N*N
    var direction = "down"
    while(num != 1) {
        if(direction == "down") {
            while(true) {
                matrix[y][x] = num
                if((y+1 == N) || (matrix[y+1][x] != 0)) {
                    break;
                }
                y += 1
                num -= 1
            }
            direction = "right"
        }
        else if (direction == "right") {
            while(true) {
                matrix[y][x] = num
                if((x+1 == N) || (matrix[y][x+1] != 0)) {
                    break;
                }
                x += 1
                num -= 1
            }
            direction = "up"
        }
        else if (direction == "up") {
            while(true) {
                matrix[y][x] = num
                if((y-1 == -1) || (matrix[y-1][x] != 0)) {
                    break;
                }
                y -= 1
                num -= 1
            }
            direction = "left"
        }
        else if (direction == "left") {
            while(true) {
                matrix[y][x] = num
                if((x-1 == -1) || (matrix[y][x-1] != 0)) {
                    break;
                }
                x -= 1
                num -= 1
            }
            direction = "down"
        }
    }

    var ansY = 0
    var ansX = 0
    for (y in 0 until matrix.size) {
        for (x in 0 until matrix[y].size) {
            if (matrix[y][x] == target) {
                ansY = y + 1
                ansX = x + 1
            }
            print("${matrix[y][x]} ")
        }
        println()
    }

    print("$ansY $ansX")
}