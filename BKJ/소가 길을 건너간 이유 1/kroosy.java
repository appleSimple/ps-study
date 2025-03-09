import java.util.*;
import java.io.*;

public class kroosy {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    int result = 0;
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < N; i++) {
      String[] arr = br.readLine().split(" ");
      String cow = arr[0];
      int location = Integer.parseInt(arr[1]);
      if (map.containsKey(cow)) {
        if(map.get(cow) != location){
          result++;
        }
      }
      map.put(cow, location);
    }
    System.out.println(result);
  }
}
