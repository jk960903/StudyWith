package Homework; 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RPSGame {
	
	private static final int ROCK = 0; // 바위
	private static final int PAPER = 1; // 보 
	private static final int SCISSORS = 2; // 가위
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
			System.out.print("계속하시겠습니까? (y/n)");
			again=sc.next();
			askContinueOrNot(again);		//틀리면 다시 함수 호출
		}
		return YesNo;
	}	
	
	public static String IsVaild(String choice) {
		finalchoice="";
		if(choice.equals("가위") || choice.equals("바위") || choice.equals("보")) {		//맞게 입력하면 finalchoice에 넣어서 반환
			finalchoice=choice;
		}
		else {
			System.out.print("다시 입력하세요!");
			choice=sc.next();
			IsVaild(choice);					//틀리게 입력하면 다시 함수호출
		}
		return finalchoice;
	}
	
	public static void WhoIsWinner(String choice1, String choice2) {
		int P1=0;
		int P2=0;
		int Winner;
		List list = new ArrayList();		//반복문으로 비교하여 인덱싱하기위해 리스트생성
		list.add("바위");
		list.add("보");
		list.add("가위");
		for(int i=0;i<3;i++) {
			if(list.get(i).equals(choice1)) {		//바위는 0 보는 1 가위는 2로 숫자부여
				P1=i;
			}
		}

		for(int i=0;i<3;i++) {
			if(list.get(i).equals(choice2)) {
				P2=i;
			}
		}

		list.clear();
		switch(P1-P2) {		//for문에서 부여한 숫자로 사칙연산하여 나올수 있는 경우를 처리
			case 1:
				System.out.println("플레이어 "+name1+"가 이겻습니다.");
				break;
			case -1:
				System.out.println("플레이어 "+name2+"가 이겻습니다.");
				break;
			case 2:
				System.out.println("플레이어 "+name2+"가 이겻습니다.");
				break;
			case -2:
				System.out.println("플레이어 "+name1+"가 이겻습니다.");
				break;
			case 0:
				System.out.println("비겼습니다.");
				break;
		}
	}
	
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("2016146036 이승현");
	System.out.print("첫 번째 플레이어 이름을 입력하세요: ");
	name1=sc.next();
	System.out.print("두 번째 플레이어 이름을 입력하세요: ");
	name2=sc.next();
	
	boolean continueGame = true;
	
	do {
		System.out.print("플레이어 "+name1+"은(는) 뭘 냅니까(가위/바위/보)?");
		choice1=sc.next();
		choice1=IsVaild(choice1);
		System.out.print("플레이어 "+name2+"은(는) 뭘 냅니까(가위/바위/보)?");
		choice2=sc.next();
		choice2=IsVaild(choice2);
		WhoIsWinner(choice1,choice2);
		System.out.print("계속하시겠습니까? (y/n)");
		again=sc.next();
		askContinueOrNot(again);
	} while ((continueGame == YesNo));
	
	System.out.println("가위바위보 게임을 종료합니다.");
	sc.close();
	}
	}