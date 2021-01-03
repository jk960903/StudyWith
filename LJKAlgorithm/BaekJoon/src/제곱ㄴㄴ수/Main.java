package Á¦°ö¤¤¤¤¼ö;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		long min=scan.nextLong();
		long max=scan.nextLong();
		boolean[] visit=new boolean[(int)(max-min+1)];
		for(long i=2; i*i<=max; i++) {
			long pow=i*i;
			long start= min%pow == 0 ? min/pow : (min/pow)+1;
			
			for(long j=start; j*pow<=max; j++) {
				long result=j*pow-min; 
				visit[(int)result]=true;
			}
		}
		long count=0;
		for(int i=0; i<=max-min; i++) {
			if(!visit[i]) {
				count++;
			}
		}
		System.out.println(count);
		
	}
}
