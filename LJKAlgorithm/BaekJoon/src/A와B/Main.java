package A¿ÍB;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String S = br.readLine();
			String T = br.readLine();
			
			StringBuilder SbS = new StringBuilder(S);
			StringBuilder SbT = new StringBuilder(T);
			while(SbS.length() != SbT.length()) {
				if(SbT.charAt(SbT.length()-1)=='A'){
					SbT.deleteCharAt(SbT.length()-1);
				}else {
					SbT.deleteCharAt(SbT.length()-1);
					SbT.reverse();
				}
			}
			if(SbS.toString().equals(SbT.toString())) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
