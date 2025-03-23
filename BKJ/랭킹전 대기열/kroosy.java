import java.io.*;
import java.util.*;

public class kroosy {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int p = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    List<List<String[]>> rooms = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < p; i++) {
      st = new StringTokenizer(br.readLine());
      int level = Integer.parseInt(st.nextToken());
      String name = st.nextToken();

      boolean assigned = false;

      for (List<String[]> room : rooms) {
        int firstLevel = Integer.parseInt(room.get(0)[0]);
        if (room.size() < m && Math.abs(firstLevel - level) <= 10) {
          room.add(new String[]{String.valueOf(level), name});
          assigned = true;
          break;
        }
      }

      if (!assigned) {
        List<String[]> newRoom = new ArrayList<>();
        newRoom.add(new String[]{String.valueOf(level), name});
        rooms.add(newRoom);
      }
    }

    for (List<String[]> room : rooms) {
      room.sort(Comparator.comparing(a -> a[1]));
      sb.append(room.size() == m ? "Started!\n" : "Waiting!\n");
      for (String[] player : room) {
        sb.append(player[0]).append(" ").append(player[1]).append("\n");
      }
    }

    System.out.print(sb);
  }
}
