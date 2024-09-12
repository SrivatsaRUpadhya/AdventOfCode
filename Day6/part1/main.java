import java.util.ArrayList;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    sc.next();
    String word;
    ArrayList<Integer> t = new ArrayList<>();
    while (sc.hasNext() && !(word = sc.next()).equals("Distance:")) {
      t.add(Integer.parseInt(word));
    }

    ArrayList<Integer> d = new ArrayList<>();
    while (sc.hasNext()) {
      d.add(Integer.parseInt(sc.next()));
    }
    sc.close();

    int res = 1;
    for (int i = 0; i < t.size(); i++) {
      int currentDuration = t.get(i);
      int record = d.get(i);
	  int count = 0;
      for (int j = currentDuration/2; j > 0; j--) {
        int dist = j * (currentDuration - j);
        if (dist > record) {
			count+=2;
        }
      }
	  if(currentDuration % 2 == 0)count--;
	  res *= count;
    }
    System.out.println(res);
  }
}
