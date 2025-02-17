public class kroosy {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine().toUpperCase();

    HashMap<Character, Integer> map = new HashMap<>();
    for (char current : line.toCharArray()) {
      map.put(current, map.getOrDefault(current, 0) + 1);
    }

    int max = map.values().stream()
        .max(Integer::compareTo)
        .orElse(-1);

    List<Character> maxKeys = new ArrayList<>();
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      if (entry.getValue() == max) {
        maxKeys.add(entry.getKey());
      }
    }
    System.out.println(maxKeys.size() == 1 ? (char) maxKeys.get(0) : '?');
  }
}
