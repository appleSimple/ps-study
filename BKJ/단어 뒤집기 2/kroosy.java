import java.util.*;
import java.io.*;

public class kroosy {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    StringBuilder result = new StringBuilder();
    StringBuilder temp = new StringBuilder();
    boolean flag = false;
    for (int i = 0; i < str.length(); i++) {
      char current = str.charAt(i);
      temp.append(current);
      if (flag) {
        if (current == '>') {
          result.append(temp);
          temp.setLength(0);
          flag = false;
        }
      } else {
        if (current == '<') {
          flag = true;
        } else if (current == ' ') {
          temp.deleteCharAt(temp.length() - 1);
          result.append(temp.reverse() + " ");
          temp.setLength(0);
        } else {
          if (i == str.length() - 1) {
            result.append(temp.reverse());
          } else {
            char next = str.charAt(i + 1);
            if (next == '<') {
              result.append(temp.reverse());
              temp.setLength(0);
            }
          }
        }
      }
    }
    System.out.println(result);
  }
}
