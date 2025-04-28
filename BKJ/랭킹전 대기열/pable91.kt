/**
 *  랭킹전 대기열
 *  https://www.acmicpc.net/problem/20006
 *
 *  1, 플레이어 p와 방의 정원 m을 입력한다
 *  2. List<Map<int, string>>를 만든다. list는 방을 의미한다.
 *  3. 플레이어 p명만큼 순회하며, 레벨과 아이디를 입력한다.
 *  4. 방을 찾을때 만약 들어갈 방이 없다면, 새 방을 만든다 (= 새로운 List 추가)
 *  5. 방이 있지만 만약 해당 방의 방장과 레벨이 -10 ~ +10 이상 차이가 나면 들어갈 수 없다.
 *  6. 방 안에 있는 플레이어들을 이름순으로 정렬한다.
 *  6. 방을 순회하며 게임을 시작한 방은 Starting, 시작 못한 방은 Wating을 출력한다. 그리고 그 안에 있는 플레이어의 레벨과 이름도 출력한다
 */
fun main() {

    val prices = readln().split(" ").map { it.toInt() }
    val p = prices[0]
    val m = prices[1]

    val rooms = mutableListOf<MutableList<Pair<Int, String>>>()

    for (i in 0 until p ) {
        val info = readln().split(" ").map { it }
        val level = info[0].toInt()
        val player = info[1]

        if(rooms.isEmpty()) {
            rooms.add(mutableListOf(level to player))
        }
        else {
            for (j in 0 until rooms.size) {
                if(rooms[j].size == m) {
                    if(j == rooms.size - 1) {
                        rooms.add(mutableListOf(level to player))
                        break
                    }
                }
                else {
                    val firstPlayerLevel = rooms[j].get(0).first
                    if(firstPlayerLevel - 10 <= level && level <= firstPlayerLevel + 10) {
                        rooms[j].add(level to player)
                        break
                    }
                    else {
                        if(j == rooms.size - 1) {
                            rooms.add(mutableListOf(level to player))
                            break
                        }
                    }
                }
            }
        }
    }

    for (room in rooms) {
        room.sortBy { it.second }
    }

    for (room in rooms) {
        if(room.size == m) {
            println("Started!")
        }
        else {
            println("Waiting!")
        }

        for (pp in room) {
            println("${pp.first} ${pp.second}")
        }
    }


}