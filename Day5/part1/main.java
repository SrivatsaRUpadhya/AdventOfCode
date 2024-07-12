import java.util.ArrayList;
import java.util.Scanner;

class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		//ArrayList<ArrayList<long[]>> map = new ArrayList<ArrayList<int[]>>();
		ArrayList<Long>map = new ArrayList<>();
		ArrayList<Integer>counts = new ArrayList<>();
		String[] seedsLine = sc.nextLine().split(" ");

		ArrayList<long[]> elem = new ArrayList<long[]>();
		int count = 0;
		while(sc.hasNextLine()){
			String line = sc.nextLine();
			if(line.length() == 0 || !Character.isDigit(line.charAt(0))){
				if(count != 0)
					if(counts.isEmpty())
						counts.add(count);
					else
						counts.add(counts.getLast() + count);
				count = 0;
				continue;
			}
			else{
				count+=3;
				String[] e = line.split(" ");
				for(String s : e)
					map.add(Long.parseLong(s));
			}
		}
		counts.add(counts.getLast() + count);

		for(int j : counts)
			System.out.println(j);
		long res = Long.MAX_VALUE;
		long nextEl = 0;
		for(int i = 1; i < seedsLine.length;i++){
			int ptr = 1;
			nextEl = Long.parseLong(seedsLine[i]);
			int idx = 0;

			while(ptr < map.size()){
				if(nextEl >= map.get(ptr) && nextEl <= (map.get(ptr) + map.get(ptr+1))){
					nextEl = nextEl - map.get(ptr) + map.get(ptr-1);
					ptr = counts.get(idx) + 1;
					idx++;
					continue;
				}
				else {
					ptr += 3;
					if(ptr > counts.get(idx))
						idx++;
				}
			}
			System.out.println(nextEl);
			res = Math.min(res,nextEl);
		}
		System.out.println(res);
	}
}
