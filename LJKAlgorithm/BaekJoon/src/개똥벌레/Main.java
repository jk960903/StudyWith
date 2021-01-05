package °³¶Ë¹ú·¹;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int h=scan.nextInt();
		int[] stone1=new int[n/2];
		int[] stone2=new int[n/2];
		int[] count=new int[h];
		for(int i=0; i<n; i++) {
			int num=scan.nextInt();
			if(i%2==0) {
				//¾Æ·¡¿¡¼­ À§·Î
				stone1[i/2]=num;
			}else {
				stone2[i/2]=num;
			}
		}
		Arrays.sort(stone1);
		Arrays.sort(stone2);
		int min=Integer.MAX_VALUE;
		for(int i=1; i<=h; i++) {
			int j=binarySearch(0,stone1.length-1,i,stone1,n);
			int k=binarySearch(0,stone2.length-1,h-i+1,stone2,n);
			count[i-1]=j+k;
			min=min>count[i-1] ? count[i-1] : min;
		}
		int stonecount=0;
		for(int i=0; i<h; i++) {
			if(count[i]==min) {
				stonecount++;
			}
		}
		System.out.println(min+" "+stonecount);
	}
	private static int binarySearch(int left,int right,int h,int[] array,int n) {
		int min=Integer.MAX_VALUE;
		while(left<=right) {
			int mid=(left+right)/2;
			if(h<=array[mid]) {
				min=Math.min(min,mid);
				right=mid-1;
			}else {
				left=mid+1;
			}
		}
		if(min==Integer.MAX_VALUE) {
			return 0;
		}else {
			return n/2-min;
		}
	}
}
