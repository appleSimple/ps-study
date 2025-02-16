import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class kroosy {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    while (true) {
      String password = br.readLine();
      if (password.equals("end")) {
        break;
      }

      if (isValid(password)) {
        sb.append("<").append(password).append("> is acceptable.\n");
      } else {
        sb.append("<").append(password).append("> is not acceptable.\n");
      }
    }

    System.out.print(sb.toString());
  }

  public static boolean isValid(String pw) {
    Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    boolean hasVowel = false;
    int count = 1;

    for (int i = 0; i < pw.length(); i++) {
      char c = pw.charAt(i);
      boolean isVowel = vowels.contains(c);

      if (isVowel) {
        hasVowel = true;
      }

      if (i > 0) {
        if ((vowels.contains(pw.charAt(i - 1)) == isVowel)) {
          count++;
          if (count == 3) {
            return false;
          }
        } else {
          count = 1;
        }

        if (c == pw.charAt(i - 1) && "eo".indexOf(c) == -1) {
          return false;
        }
      }
    }

    return hasVowel;
  }
}
