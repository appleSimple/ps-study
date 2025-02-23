import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// import java.util.stream.Collectors;

public class kroosy {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]); // 총 단어 개수
    int M = Integer.parseInt(input[1]); // 단어 기준 길이

    HashMap<String, Integer> map = new HashMap<>();
    for (int i = 0; i < N; i++) {
      String current = br.readLine();
      if (current.length() >= M) {
        map.put(current, map.getOrDefault(current, 0) + 1);
      }
    }

    List<String> resultList = map.entrySet().stream()
        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
            .thenComparing(entry -> entry.getKey().length(), Comparator.reverseOrder())
            .thenComparing(entry -> entry.getKey()))
        .map(Map.Entry::getKey)
        .toList();
    // .collect(Collectors.toList()); // Java 8 호환 (toList() 대신 사용)

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (String s : resultList) {
      bw.write(s + "\n");
    }
    bw.flush();
    bw.close();
  }
}
