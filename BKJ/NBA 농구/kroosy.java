import java.util.*;
import java.io.*;

public class kroosy {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int score1 = 0, score2 = 0;
    int time1 = 0, time2 = 0;
    int lastTime = 0;

    for (int i = 0; i < N; i++) {
      String[] input = br.readLine().split(" ");
      int team = Integer.parseInt(input[0]);
      int currentTime = toSeconds(input[1]);

      if (score1 > score2) {
        time1 += (currentTime - lastTime);
      }
      if (score2 > score1) {
        time2 += (currentTime - lastTime);
      }

      if (team == 1) {
        score1++;
      } else {
        score2++;
      }

      lastTime = currentTime;
    }

    if (score1 > score2) {
      time1 += (48 * 60 - lastTime);
    }
    if (score2 > score1) {
      time2 += (48 * 60 - lastTime);
    }

    System.out.println(formatTime(time1));
    System.out.println(formatTime(time2));
  }

  private static int toSeconds(String time) {
    int minutes = Integer.parseInt(time.substring(0, 2));
    int seconds = Integer.parseInt(time.substring(3, 5));
    return minutes * 60 + seconds;
  }

  private static String formatTime(int seconds) {
    int minutes = seconds / 60;
    seconds %= 60;
    return String.format("%02d:%02d", minutes, seconds);
  }
}
