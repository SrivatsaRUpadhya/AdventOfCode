import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String line = "";
		while(sc.hasNextLine()){
			line = sc.nextLine();
			sb.append(line);
		}
		String s = sb.toString();
		//System.out.println(sb.toString());
		sc.close();

		int i = 0;
		int sum = 0;
		int[] toCheck = {1,line.length()-1,line.length(),line.length() + 1};
		while(i < s.length()){
			boolean isPart = false;
			while(i < s.length() && !Character.isDigit(s.charAt(i))) i++;
			i = i > 0 ? i-- : 0;
			int j = i;
			Pattern p = Pattern.compile("[^a-z0-9.]");
			while(j < s.length() && Character.isDigit(s.charAt(j))){
				//System.out.println(i+" "+j);
				Matcher m ;
				for(int k : toCheck){
					if((j + k) < s.length() ){
						m = p.matcher(s.substring(j+k,j+k+1));
						//System.out.println(s.substring(j+k,j+k+1));
						if(m.matches()){
							isPart = true;
							break;
						}
					}
					if((j - k) > 0 ){
						m = p.matcher(s.substring(j-k,j-k+1));
						//System.out.println(s.substring(j-k,j-k+1));
						if(m.matches()){
							isPart = true;
							break;
						}
					}
				}
				//System.out.println(s.substring(i,j+1));
				if(isPart)
					break;
				else j++;
			}
			if(isPart){
				while(Character.isDigit(s.charAt(j))) j++;
				String t = s.substring(i,j);
				//System.out.println(t);
				if(t != "")
					sum += Integer.parseInt(t);
				i = j;
			}
			else i++;
		}
		System.out.println(sum);
	}
}
