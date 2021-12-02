package ZeroBase;

import java.util.Scanner;
public class Problem2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("[메뉴선택]\n1.회원 관리\n2.과목 관리\n3.수강 관리\n4.결제 관리\n5.종료");
			int num = scan.nextInt();
			if(num == 1) {
				System.out.println("회원 관리 메뉴를 선택했습니다.");
			}else if(num==2) {
				System.out.println("과목 관리 메뉴를 선택했씁니다.");
			}else if(num==3) {
				System.out.println("수강 관리 메뉴를 선택했습니다.");
			}else if(num==4) {
				System.out.println("결제 관리 메뉴를 선택했습니다.");
			}else if(num==5) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}
}
