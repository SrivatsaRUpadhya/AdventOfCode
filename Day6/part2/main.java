import java.util.ArrayList;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    sc.next();
    String word;
    StringBuilder sb = new StringBuilder();
    while (sc.hasNext() && !(word = sc.next()).equals("Distance:")) {
      sb.append(word);
    }
    int t = Integer.parseInt(sb.toString());

    sb.delete(0, sb.length());
    while (sc.hasNext()) {
      sb.append(sc.next());
    }
    long d = Long.parseLong(sb.toString());
    sc.close();
    System.out.println(t);
    System.out.println(d);

    long res = 1;
    int count = 0;
    for (long j = t / 2; j > 0; j--) {
      long dist = j * (t - j);
      if (dist > d) {
        count += 2;
      }
    }
    if (t % 2 == 0)
      count--;
    res *= count;
    System.out.println(res);
  }
}
