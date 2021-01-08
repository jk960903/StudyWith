package HighestValuePalindrome;
import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int k=scan.nextInt();
		scan.nextLine();
		String num=scan.nextLine();
		int[] count=new int[10];
		char[] numtoarray=num.toCharArray();
		StringBuilder sb=new StringBuilder();
		for(int i=0; i<numtoarray.length; i++) {
			int temp=numtoarray[i]-'0';
			count[temp]++;
		}
		int oddcount=0;
		
		if(n%2==0) {//礎熱望檜
			for(int i=0; i<9; i++) {
				if(count[i]%2!=0&&k>0) {
					count[i]--;
					k--;
					count[9]++;
				}
			}
			for(int i=0; i<=9; i++) {
				if(count[i]%2!=0) {
					System.out.println(-1);
					return;
				}
			}
			

			for(int i=0; i<=8; i++) {
				while(k>=2) {
					if(count[i]>=2) {
						count[i]-=2;
						count[9]+=2;
						k-=2;
					}else {
						break;
					}
				}
			}
				
				for(int i=9; i>=0; i--) {
					for(int j=0; j<count[i]/2; j++) {
						sb.append(i);
					}
					count[i]/=2;
				}
				for(int i=0; i<=9; i++) {
					for(int j=0; j<count[i]; j++) {
						sb.append(i);
					}
				}
		}
		else {//�汝鰡磍�
			for(int i=0; i<9; i++) {
				if(count[i]%2!=0&&k>0) {
					count[i]--;
					k--;
					count[9]++;
				}
			}
			int oddindex=0;;
			for(int i=0; i<=9; i++) {
				if(count[i]%2!=0) {
					oddcount++;
					oddindex=i;
				}
				if(oddcount>2) {
					System.out.println(-1);
					return;
				}
			}
			for(int i=0; i<=8; i++) {
				while(k>=2) {
					if(count[i]>=2) {
						count[i]-=2;
						count[9]+=2;
						k-=2;
					}else {
						break;
					}
				}
			}
			for(int i=9; i>=0; i--) {
				for(int j=0; j<count[i]/2; j++) {
					sb.append(i);
				}
				count[i]/=2;
			}
			sb.append(oddindex);
			count[oddindex]--;
			for(int i=0; i<=9; i++) {
				for(int j=0; j<count[i]; j++) {
					sb.append(i);
				}
			}
		}
		System.out.println(sb);
	}
}
