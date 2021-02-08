package baek;

import java.util.Scanner;

public class main2847 {
		
		static int count;
		

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		
		int index=arr.length-1;

		
		while(index!=0) {
	
		if(arr[index]<=arr[index-1]) {
			arr[index-1]=arr[index-1]-1;
			count++;
		}
		else {
			index--;
		}
		}
		
		System.out.println(count);
	}

}
