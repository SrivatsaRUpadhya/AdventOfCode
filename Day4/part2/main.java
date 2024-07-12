import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer>wins = new ArrayList<Integer>();
		ArrayList<Integer>cardsCnts = new ArrayList<Integer>();

		int count = 0;

		while(sc.hasNextLine()){
			HashSet<String>st= new HashSet<String>();
			boolean done = false;
			String s = sc.nextLine();
			cardsCnts.add(1);

			Scanner test = new Scanner(s);
			test.next();
			test.next();

			while(test.hasNext()){
				String w = test.next();
				//System.out.println(s);
				if(w.equals("|"))
					done = true;

				if(done){
					if(st.contains(w)){
						count++;
					}
				}
				else{
					st.add(w);
				}
			}
			st.clear();
			wins.add(count);
			count = 0;
			test.close();
		}

		for(int i = 0; i < wins.size(); i++){
			for(int j = 1; j <= wins.get(i) && i + j < cardsCnts.size(); j++){
				int something = cardsCnts.get(i+j) + cardsCnts.get(i);
				cardsCnts.set(i+j, something);
			}
		}
		int res = 0;
		for(int j : cardsCnts){
			res += j;
		}
		System.out.println(res);
		sc.close();
	}
}
