import java.util.ArrayList;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    ArrayList<ArrayList<ArrayList<Long>>> maps = new ArrayList<>();
    ArrayList<ArrayList<Long>> type = new ArrayList<>();

    Scanner sc = new Scanner(System.in);
    String[] SeedLine = sc.nextLine().split(" ");
    sc.nextLine();
    String line;
    while (sc.hasNextLine()) {
      line = sc.nextLine();
      if (!line.isBlank() && !Character.isDigit(line.charAt(0)))
        continue;

      if (line.isBlank()) {
        maps.add(new ArrayList<>(type));
        type.clear();
      } else {
        ArrayList<Long> mapElem = new ArrayList<>();
        for (String n : line.split(" ")) {
          mapElem.add(Long.parseLong(n));
        }
        type.add(mapElem);
      }
    }
    maps.add(type);

    long res = Integer.MAX_VALUE;
    for (int i = 1; i < SeedLine.length - 1; i += 2) {
      long start = Long.parseLong(SeedLine[i]);
      long end = Long.parseLong(SeedLine[i] ) + Integer.parseInt(SeedLine[i + 1]);

      for (long c = start; c < end; c++) {
        long toFind = c;
        for (ArrayList<ArrayList<Long>> t : maps) {
          for (ArrayList<Long> l : t) {
            if (toFind >= l.get(1) && toFind <= (l.get(1) + l.get(2))) {
              toFind = l.get(0) + toFind - l.get(1);
              break;
            }
          }
        }
        res = Math.min(res, toFind);
      }
    }
    System.out.println(res);
    sc.close();
  }
}
