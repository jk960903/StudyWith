package baek;

import java.util.Arrays;
import java.util.Scanner;

public class main16112 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int sum = 0;
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		Arrays.sort(arr);
		for(int i=0;i<n;i++) {
			sum=arr[i]*(i)+sum;
		}
		System.out.println(sum);
	}
}
