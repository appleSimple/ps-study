import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class kroosy {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputCount = br.readLine().split(" ");
    int N = Integer.parseInt(inputCount[0]);
    int M = Integer.parseInt(inputCount[1]);

    HashSet<String> noListenSet = new HashSet<>();
    List<String> resultList = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      noListenSet.add(br.readLine());
    }
    for (int i = 0; i < M; i++) {
      String current = br.readLine();
      if(noListenSet.contains(current)){
        resultList.add(current);
      }
    }
    System.out.println(resultList.size());
    resultList.stream().sorted().forEach(System.out::println);
  }
}
