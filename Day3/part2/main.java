import java.util.*;
class Main{
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		String l = "";
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()){
			l = sc.nextLine();
			sb.append(l);
		}
		String s = sb.toString();
		int sum = 0;
		int pos_star = 0;

		while(pos_star < s.length()){
			while(pos_star < s.length() && s.charAt(pos_star) != '*') pos_star++;
			if(pos_star > s.length()) break;
			ArrayList<Integer> used = new ArrayList<Integer>();
			int a=0,b = 1,first = -1,second = -1;
			int[] toLook = {1,l.length()};
			for(int k : toLook){
				int[] offset;
				if(k == 1){
					offset = new int[] {0};
				}
				else{
					offset = new int[] {0,1,-1};
				}
				for(int c : offset){
					if(first != -1 && second != -1) break;
					if((pos_star+c+k < s.length()) && Character.isDigit(s.charAt(pos_star+k+c))){
						a = b = pos_star + k + c;
						//System.out.println(s.charAt(pos_star+1));
						while(a >= 0 && Character.isDigit(s.charAt(a))) a--;
						while(b < s.length() && Character.isDigit(s.charAt(b))) b++;
						if(!used.contains(a+1) && !used.contains(b-1)){
							if(first == -1)
								first = Integer.parseInt(s.substring(a+1,b));
							else 
								second  = Integer.parseInt(s.substring(a+1,b));
							used.add(a+1);
							used.add(b-1);
						}
					}
					if((pos_star+c-k > 0) && Character.isDigit(s.charAt(pos_star-k+c))){
						a = b = pos_star - k + c;
						//System.out.println(s.charAt(pos_star-1) + " " + pos_star);
						while(a >= 0 && Character.isDigit(s.charAt(a))) a--;
						while(b < s.length() && Character.isDigit(s.charAt(b))) b++;
						if(!used.contains(a+1) && !used.contains(b-1)){
							if(first == -1)
								first = Integer.parseInt(s.substring(a+1,b));
							else
								second = Integer.parseInt(s.substring(a+1,b));
							used.add(a+1);
							used.add(b-1);

						}
					}
				}
			}
			System.out.println(first + " " + second);
			if(first != -1 && second != -1){
				sum += first * second;
			}
			pos_star += 1;
		}
		System.out.println(sum);
	}
}
