package ZeroBase;

import java.util.Scanner;
public class Problem2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("[�޴�����]\n1.ȸ�� ����\n2.���� ����\n3.���� ����\n4.���� ����\n5.����");
			int num = scan.nextInt();
			if(num == 1) {
				System.out.println("ȸ�� ���� �޴��� �����߽��ϴ�.");
			}else if(num==2) {
				System.out.println("���� ���� �޴��� �����߾��ϴ�.");
			}else if(num==3) {
				System.out.println("���� ���� �޴��� �����߽��ϴ�.");
			}else if(num==4) {
				System.out.println("���� ���� �޴��� �����߽��ϴ�.");
			}else if(num==5) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
		}
	}
}
