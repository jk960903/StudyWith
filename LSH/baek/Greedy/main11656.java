package baek;

import java.util.Arrays;
import java.util.Scanner;

public class main11656 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		String[] tail = new String[input.length()];
		for(int i=0;i<input.length();i++) {
			tail[i]=input.substring(i,input.length());
		}
		Arrays.sort(tail);
		for(int i=0;i<input.length();i++) {
			System.out.println(tail[i]);
		}
	}
}
