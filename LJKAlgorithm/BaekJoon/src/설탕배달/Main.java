package º≥≈¡πË¥ﬁ;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		int n=scan.nextInt();
		int answer=0;
		while(true) {
			if(n%5==0) {
				System.out.println(n/5+answer);
				break;
			}else if(n<=0) {
				System.out.println(-1);
			}
			n=n-3;
			answer++;
		}
	}
}
