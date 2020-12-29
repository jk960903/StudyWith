package 알람시계;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int H=scan.nextInt();
		int M=scan.nextInt();
		int temp=H*60+M;
		temp=temp-45;
		int h=0;
		int m=0;
		if(temp<0) {
			h=23;
			m=60+temp;
		}else {
			h=temp/60;
			m=temp%60;	
		}
		System.out.println(h+" "+m);
	}
}
