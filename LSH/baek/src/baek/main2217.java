package baek;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class main2217 {

	public static void main(String[] args) {
		long max=0;
		Scanner sc= new Scanner(System.in);
		int num=sc.nextInt();
		int[] array = new int[num];
		
		for(int i=0;i<num;i++) {
			array[i]=sc.nextInt();
		}
		
		Arrays.sort(array);
		
		for(int i=0;i<num;i++) {
			if(array[num-i-1]-i>=0) {
			max+=array[num-i-1]-i;	//array[num-1-i]-(i+1-1)
			}
			else break;
		}
		System.out.println(max);	

	}
}
