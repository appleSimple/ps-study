import java.io.*;
import java.util.*;

public class kroosy {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int Len = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    Map<String, Integer> map = new TreeMap<>();
    for (int i = 0; i < Len; i++) {
      String str = br.readLine();
      String ext = str.substring(str.indexOf('.') + 1);
      map.put(ext, map.getOrDefault(ext, 0) + 1);
    }

    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
    }

    System.out.print(sb);
  }
}
