package ÆÓ¸°µå·Ò;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String s = br.readLine();
			boolean check = true;
			for(int i = 0; i <s.length()/2; i++) {
				if(s.charAt(i) != s.charAt(s.length() - i - 1 )) {
					check = false;
					break;
				}
			}
			if(!check) {
				System.out.println("false");
			}else {
				System.out.println("true");
			}
		}catch(Exception e) {
			
		}
	}
}
