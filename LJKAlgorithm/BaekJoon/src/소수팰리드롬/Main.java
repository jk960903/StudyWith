package 소수팰리드롬;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		if(n==1) {
			System.out.println(2);
			return;
		}
		for(int i=n; ; i++) {
			if(isPrime(i)) {
				if(isPalendrom(i)) {
					System.out.println(i);
					return;
				}
			}
		}
	}
	private static boolean isPrime(int num) {
		for(int i=2; i*i<=num; i++) {
			if(num%i==0)return false;
		}
		return true;
	}
	private static boolean isPalendrom(int num) {
		int[] array=new int[10];
		char[] temp=Integer.toString(num).toCharArray();
		for(int i=0; i<temp.length; i++) {
			int digit=temp[i]-'0';
			array[digit]++;
		}
		if(temp.length%2==0) {
			for(int i=0; i<10; i++) {
				if(array[i]%2==1) {
					return false;
				}
			}
			for(int i=0; i<temp.length/2; i++) {
				if(temp[i]!=temp[temp.length-1-i])return false;
			}
			return true;
		}else {
			int oddcount=0;
			for(int i=0; i<10; i++) {
				if(array[i]%2==1) {
					oddcount++;
				}if(oddcount==2) {
					return false;
				}
			}
			for(int i=0; i<temp.length/2; i++) {
				if(temp[i]!=temp[temp.length-1-i])return false;
			}
			return true;
		}
	}
}
