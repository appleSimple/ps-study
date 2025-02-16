public class kroosy {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    List<String> list = new ArrayList<>();
    int maxLen = 0;

    for (int i = 0; i < 5; i++) {
      String line = br.readLine();
      list.add(line);
      maxLen = Math.max(maxLen, line.length());
    }

    StringBuilder sb = new StringBuilder();
    for (int j = 0; j < maxLen; j++) {
      for (int i = 0; i < 5; i++) {
        if (j < list.get(i).length()) {
          sb.append(list.get(i).charAt(j));
        }
      }
    }

    System.out.println(sb.toString());
  }

}
