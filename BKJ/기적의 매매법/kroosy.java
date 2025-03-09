import java.util.*;
import java.io.*;

public class kroosy {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int asset = Integer.parseInt(br.readLine());
    int[] prices = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    int bCash = asset;
    int bStock = 0;
    for (int i = 0; i < prices.length; i++) {
      int buyCount = (bCash / prices[i]);
      bCash -= prices[i] * buyCount;
      bStock += buyCount;
      if (bCash == 0) {
        break;
      }
    }

    int tCash = asset;
    int tStock = 0;
    int trends = 0;
    for (int i = 0; i < prices.length; i++) {
      if (trends == 3) {
        tCash = tStock * prices[i];
        tStock = 0;
      } else if (trends == -3) {
        int buyCount = (tCash / prices[i]);
        tCash -= prices[i] * buyCount;
        tStock += buyCount;
      }

      if (i > 0) {
        int trend = prices[i] - prices[i - 1];
        if (trend > 0) {
          if (trends >= 0) {
            trends++;
          } else {
            trends = -1;
          }
        } else if (trend < 0) {
          if (trends > 0) {
            trends = -1;
          } else if (trends <= 0) {
            trends--;
          }
        } else {
          trends = 0;
        }
      }
    }

    int bnp = bCash + bStock * prices[prices.length - 1];
    int timing = tCash + tStock * prices[prices.length - 1];
    if (bnp > timing) {
      System.out.println("BNP");
    } else if (bnp < timing) {
      System.out.println("TIMING");
    } else {
      System.out.println("SAMESAME");
    }
  }
}
