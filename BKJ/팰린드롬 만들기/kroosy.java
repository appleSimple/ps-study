import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class kroosy {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    Map<Character, Integer> map = new TreeMap<>();
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    List<Entry<Character, Integer>> list = map.entrySet().stream().toList();
    List<Entry<Character, Integer>> odds = list.stream().filter(v -> v.getValue() % 2 == 1)
        .toList();
    StringBuilder half = new StringBuilder();
    if (str.length() % 2 == 0) {
      if (odds.size() > 0) {
        System.out.println("I'm Sorry Hansoo");
      }
      for (int i = 0; i < list.size(); i++) {
        char c = list.get(i).getKey();
        int v = list.get(i).getValue();
        String repeated = String.valueOf(c).repeat(v / 2);
        half.append(repeated);
      }
      System.out.println(half.append(new StringBuilder(half).reverse()));
    } else {
      if (odds.size() != 1) {
        System.out.println("I'm Sorry Hansoo");
      }
      char oddC = ' ';
      for (int i = 0; i < list.size(); i++) {
        char c = list.get(i).getKey();
        int v = list.get(i).getValue();
        if (v % 2 == 1) {
          oddC = c;
        }
        half.append(String.valueOf(c).repeat(v / 2));
      }
      String result = half.toString() + (oddC != '\0' ? oddC : "") + half.reverse();
      System.out.println(result);
    }
  }
}
