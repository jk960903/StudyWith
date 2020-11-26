package Homework; 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RPSGame {
	
	private static final int ROCK = 0; // ����
	private static final int PAPER = 1; // �� 
	private static final int SCISSORS = 2; // ����
	static Scanner sc = new Scanner(System.in);
	static String name1;
	static String name2;
	static String choice1;
	static String choice2;
	static String finalchoice;
	static String again;
	static boolean YesNo;
	
	private static boolean askContinueOrNot(String again) {		
		YesNo=true;
		
		if(again.equals("y") ||again.equals("Y") ) {
			YesNo=true;
		}
		else if(again.equals("n") || again.equals("N")) {
			YesNo=false;
		}
		else {
			System.out.print("����Ͻðڽ��ϱ�? (y/n)");
			again=sc.next();
			askContinueOrNot(again);		//Ʋ���� �ٽ� �Լ� ȣ��
		}
		return YesNo;
	}	
	
	public static String IsVaild(String choice) {
		finalchoice="";
		if(choice.equals("����") || choice.equals("����") || choice.equals("��")) {		//�°� �Է��ϸ� finalchoice�� �־ ��ȯ
			finalchoice=choice;
		}
		else {
			System.out.print("�ٽ� �Է��ϼ���!");
			choice=sc.next();
			IsVaild(choice);					//Ʋ���� �Է��ϸ� �ٽ� �Լ�ȣ��
		}
		return finalchoice;
	}
	
	public static void WhoIsWinner(String choice1, String choice2) {
		int P1=0;
		int P2=0;
		int Winner;
		List list = new ArrayList();		//�ݺ������� ���Ͽ� �ε����ϱ����� ����Ʈ����
		list.add("����");
		list.add("��");
		list.add("����");
		for(int i=0;i<3;i++) {
			if(list.get(i).equals(choice1)) {		//������ 0 ���� 1 ������ 2�� ���ںο�
				P1=i;
			}
		}

		for(int i=0;i<3;i++) {
			if(list.get(i).equals(choice2)) {
				P2=i;
			}
		}

		list.clear();
		switch(P1-P2) {		//for������ �ο��� ���ڷ� ��Ģ�����Ͽ� ���ü� �ִ� ��츦 ó��
			case 1:
				System.out.println("�÷��̾� "+name1+"�� �̰���ϴ�.");
				break;
			case -1:
				System.out.println("�÷��̾� "+name2+"�� �̰���ϴ�.");
				break;
			case 2:
				System.out.println("�÷��̾� "+name2+"�� �̰���ϴ�.");
				break;
			case -2:
				System.out.println("�÷��̾� "+name1+"�� �̰���ϴ�.");
				break;
			case 0:
				System.out.println("�����ϴ�.");
				break;
		}
	}
	
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("2016146036 �̽���");
	System.out.print("ù ��° �÷��̾� �̸��� �Է��ϼ���: ");
	name1=sc.next();
	System.out.print("�� ��° �÷��̾� �̸��� �Է��ϼ���: ");
	name2=sc.next();
	
	boolean continueGame = true;
	
	do {
		System.out.print("�÷��̾� "+name1+"��(��) �� ���ϱ�(����/����/��)?");
		choice1=sc.next();
		choice1=IsVaild(choice1);
		System.out.print("�÷��̾� "+name2+"��(��) �� ���ϱ�(����/����/��)?");
		choice2=sc.next();
		choice2=IsVaild(choice2);
		WhoIsWinner(choice1,choice2);
		System.out.print("����Ͻðڽ��ϱ�? (y/n)");
		again=sc.next();
		askContinueOrNot(again);
	} while ((continueGame == YesNo));
	
	System.out.println("���������� ������ �����մϴ�.");
	sc.close();
	}
	}