import java.util.*;
import java.io.*;

public class kroosy {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] arr = br.readLine().split(" ");
    int N = Integer.parseInt(arr[0]);
    int M = Integer.parseInt(arr[1]);

    int[] status = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    for (int i = 0; i < M; i++) {
      int[] commands = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
          .toArray();
      int c = commands[0];
      int v1 = commands[1];
      int v2 = commands[2];
      if (c == 1) {
        status[v1 - 1] = v2;
      } else if (c == 2) {
        for (int j = v1; j <= v2; j++) {
          status[j - 1] = status[j - 1] == 0 ? 1 : 0;
        }
      } else if (c == 3) {
        for (int j = v1; j <= v2; j++) {
          status[j - 1] = 0;
        }
      } else {
        for (int j = v1; j <= v2; j++) {
          status[j - 1] = 1;
        }
      }
    }
    // 답 출력
    for (int num : status) {
      System.out.print(num + " ");
    }
  }

}
