package baek;

import java.util.Scanner;

public class main2810 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		String s = sc.next();
		String s2 = s;
		//System.out.println(s2);
		s2 = s2.replaceAll("S", "*S*");
		s2 = s2.replaceAll("LL", "*LL*");
		s2 = s2.replaceAll("\\*\\*", "*");
		//System.out.println(s2);
		int cnt = 0;
		for(int i=0; i<s2.length(); i++)
			if(s2.charAt(i) == '*')
				cnt++;
		System.out.println(s.length() < cnt ? s.length() : cnt);	//s.length()출력일때는 전부 S일때 cnt는 한개라도 LL일때
		
	}
}

//  *S*S*S*S*S*LL*