package Zerobase3Weeks;

import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // ��ĳ�� �Է�
		try {
			List<dot> list = new ArrayList<>(); //�Է� ��ǥ�� �� ����Ʈ 
			Set<String> set = new HashSet<>(); //������ǥ�� �Էµɽ� Ȯ���� set
			System.out.println("���� X��ǥ�� �Է����ּ���");
			int myx = scan.nextInt();
			
			System.out.println("���� Y��ǥ�� �Է����ּ���");
			int myy = scan.nextInt();
			
			double min = Double.MAX_VALUE ; //�ִܰŸ� ����
			dot mindot = new dot(); //�ִ� ��ǥ
			for(int i = 1; i<=10 ; i++) {
				System.out.println(i+"/10 ��° �Է�");
				System.out.println("������ x��ǥ�� �Է����ּ���");
				int tempx = scan.nextInt();
				System.out.println("������ Y��ǥ�� �Է����ּ���");
				int tempy = scan.nextInt();
				
				StringBuilder sb = new StringBuilder();
				sb.append(Integer.toString(tempx)+","+Integer.toString(tempy));
				if(set.contains(sb.toString())){
					System.out.println("�̹� �Է��� ��ǥ�Դϴ�.");
					i--;
					continue;
				}else {
					dot d = new dot(tempx,tempy);
					d.distance = Math.sqrt(((double)(myx-tempx)*(double)(myx-tempx)) + ((myy - tempy)* (double)(myy-tempy))); //���� �Էµ� ��ǥ�� ���� ��ǥ���� �Ÿ� ���
					if(d.distance < min) { //min������ ������ ����
						mindot.x = tempx;
						mindot.y = tempy;
						mindot.distance = d.distance;
						min = d.distance;
					}
					list.add(d); //list�� ������ �Է���ǥ �߰�
					set.add(sb.toString()); //�ٽ� �Է¹����ʵ��� set�� ���� �߰� 
				}
			}
			
			//��º�
			for(int i = 0 ; i< list.size(); i++) {
				dot d = list.get(i);
				
				System.out.println("("+d.x+","+d.y+") => "+d.distance);
			}
			
			System.out.println("���ϰ���� ��ǥ��:");
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
