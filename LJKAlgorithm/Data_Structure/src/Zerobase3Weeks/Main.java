package Zerobase3Weeks;

import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // 스캐너 입력
		try {
			List<dot> list = new ArrayList<>(); //입력 좌표가 들어갈 리스트 
			Set<String> set = new HashSet<>(); //동일좌표가 입력될시 확인할 set
			System.out.println("나의 X좌표를 입력해주세요");
			int myx = scan.nextInt();
			
			System.out.println("나의 Y좌표를 입력해주세요");
			int myy = scan.nextInt();
			
			double min = Double.MAX_VALUE ; //최단거리 측정
			dot mindot = new dot(); //최단 좌표
			for(int i = 1; i<=10 ; i++) {
				System.out.println(i+"/10 번째 입력");
				System.out.println("임의의 x좌표를 입력해주세요");
				int tempx = scan.nextInt();
				System.out.println("임의의 Y좌표를 입력해주세요");
				int tempy = scan.nextInt();
				
				StringBuilder sb = new StringBuilder();
				sb.append(Integer.toString(tempx)+","+Integer.toString(tempy));
				if(set.contains(sb.toString())){
					System.out.println("이미 입력한 좌표입니다.");
					i--;
					continue;
				}else {
					dot d = new dot(tempx,tempy);
					d.distance = Math.sqrt(((double)(myx-tempx)*(double)(myx-tempx)) + ((myy - tempy)* (double)(myy-tempy))); //현재 입력된 좌표와 나의 좌표와의 거리 계산
					if(d.distance < min) { //min값보다 작을때 갱신
						mindot.x = tempx;
						mindot.y = tempy;
						mindot.distance = d.distance;
						min = d.distance;
					}
					list.add(d); //list에 임의의 입력좌표 추가
					set.add(sb.toString()); //다시 입력받지않도록 set을 통해 추가 
				}
			}
			
			//출력부
			for(int i = 0 ; i< list.size(); i++) {
				dot d = list.get(i);
				
				System.out.println("("+d.x+","+d.y+") => "+d.distance);
			}
			
			System.out.println("제일가까운 좌표는:");
			System.out.println("("+mindot.x+","+mindot.y+") => "+mindot.distance);
			
			scan.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
class dot{
	int x;
	int y;
	double distance;
	public dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public dot() {
		
	}
}
