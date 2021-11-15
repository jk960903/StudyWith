package 부분문자열;
import java.io.*;
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String s = br.readLine();
			String part = br.readLine();
			StringBuilder sb = new StringBuilder();
			boolean result = kmp(s,part);
			if(result) {
				System.out.println(1);
				
			}else {
				System.out.println(0);
			}
				
		}catch(Exception e) {
			
		}
		
	}
	public static boolean kmp(String s,String part) {
		boolean answer = false;
		int j = 0;
		int[] pi = getPi(part);
		for(int i = 0 ; i<s.length(); i++) {
			while(j>0 && s.charAt(i) != part.charAt(j)) {
				j = pi[j-1];
			}
			if(s.charAt(i) == part.charAt(j)) {
				if(j == part.length()-1) {
					answer = true;
					break;
				}else {
					j++;
				}
			}
		}
		return answer;
	}
	public static int[] getPi(String pattern) {
		int[] pi = new int[pattern.length()];
		int j = 0;
		for(int i = 1; i<pattern.length(); i++){
			while(j > 0 && pattern.charAt(i)!=pattern.charAt(j)) {
				j = pi[j-1];
			}
			if(pattern.charAt(i) == pattern.charAt(j))
				pi[i] = ++j;
		}
		
		return pi;
	}
}
