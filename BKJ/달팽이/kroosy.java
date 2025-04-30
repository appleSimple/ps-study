import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int target = Integer.parseInt(br.readLine());

    int[][] arr = new int[N][N];
    int r = 0, c = 0;
    int tr = 0, tc = 0;
    // 아래 -> 오른 -> 위 -> 왼

    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};
    int dir = 0;

    for (int v = N * N; v >= 1; v--) {
      arr[r][c] = v;

      if (target == v) {
        tr = r + 1;
        tc = c + 1;
      }

      int nr = r + dr[dir];
      int nc = c + dc[dir];

      if (nr < 0 || nr >= N || nc < 0 || nc >= N || arr[nr][nc] != 0) {
        dir = (dir + 1) % 4;
        nr = r + dr[dir];
        nc = c + dc[dir];
      }

      r = nr;
      c = nc;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        sb.append(arr[i][j]).append(" ");
      }
      sb.append("\n");
    }
    sb.append(tr).append(" ").append(tc);
    System.out.println(sb);
  }

}
