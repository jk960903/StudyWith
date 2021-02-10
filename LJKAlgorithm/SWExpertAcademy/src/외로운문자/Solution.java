package 외로운문자;
import java.util.HashSet;
import java.io.*;
import java.util.Arrays;
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(br.readLine());
		for(int i=1; i<=tc; i++) {
			String s=br.readLine();
			HashSet<Character> set=new HashSet<>();
			for(int j=0; j<s.length(); j++) {
				if(set.contains(s.charAt(j))) {
					set.remove(s.charAt(j));
				}else {
					set.add(s.charAt(j));
				}
			}
			if(set.size()==0) System.out.println("#"+i+" Good");
			else {
				StringBuilder sb=new StringBuilder();
				for(char c : set) {
					sb.append(c);
				}
				char[] temp=sb.toString().toCharArray();
				Arrays.sort(temp);
				sb=new StringBuilder();
				for(int j=0; j<temp.length; j++) {
					sb.append(temp[j]);
				}
				
				System.out.println("#"+i+" "+sb.toString());
			}
		}
		
		
	}
}
