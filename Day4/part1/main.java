import java.util.*;

class Main{
	public static ArrayList<Integer> getNums(String str){
		ArrayList<Integer> list = new ArrayList<Integer>();
		int i = 0;
		while(i < str.length() && str.charAt(i) == ' ')i++;
		int j = str.length()-1;
		while(j > 0 && str.charAt(j) == ' ')j--;
		str = str.substring(i,j+1);
		i = j = 0;
		while(i < str.length()){
			while(i < str.length() && str.charAt(i) == ' ')i++;
			if(i >= str.length())break;
			j = i;
			while(j < str.length() && str.charAt(j) != ' ')j++;
			//System.out.println(str.substring(i,j));
			list.add(Integer.parseInt(str.substring(i,j)));
			i = j;
		}
		return list;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int points = 0;
		while(sc.hasNextLine()){
			String s = sc.nextLine();
			int pos_colon = s.indexOf(':');
			int pos_bar = s.indexOf('|');
			String winningStr = s.substring(pos_colon+1,pos_bar);
			String yourStr = s.substring(pos_bar+1);
			ArrayList<Integer>winningList = getNums(winningStr);
			ArrayList<Integer>yourList = getNums(yourStr);
			int count = 0;
			for(int i : yourList){
				if(winningList.contains(i)) count++;
			}
			if(count == 1){
				points+=1;
			}
			else if(count > 1){
				points+=Math.pow(2,count-1);
			}
		}
		System.out.println(points);
	}
}
