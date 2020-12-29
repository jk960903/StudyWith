package �����ڸ���;
//���� 2805��  https://www.acmicpc.net/problem/2805
import java.util.Scanner;
import java.util.Arrays;
public class Main {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();//������ ����
		int M=scan.nextInt(); //������ ������ ����
		int[] woods=new int[n];
		for(int i=0; i<n; i++) {
			woods[i]=scan.nextInt();
		}
		Arrays.sort(woods);
		int left=1;
		int right=woods[n-1];
		while(left<=right) {
			long cut=0;
			int mid=(left+right)/2;
			for(int i=0; i<woods.length; i++) {
				if(woods[i]>=mid) {
					cut+=(woods[i]-mid);
				}
			}
			if(cut>=M) {
				left=mid+1;
			}else {
				right=mid-1;
			}
			
		}
		System.out.println(right);
		
	}
	
}
