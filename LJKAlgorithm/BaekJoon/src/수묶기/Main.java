package ¼ö¹­±â;
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int[] array = new int[num];
		
		int minus = 0;
		
		for(int i = 0 ; i <array.length; i++) {
			array[i] = Integer.parseInt(br.readLine());
			if(array[i] <= 0) {
				minus++;
			}
		}
		
		Arrays.sort(array);
		
		int answer = 0 ;
		
		for(int i = 1; i < minus; i+=2) {
			answer += array[i] * array[i-1];
		}
		if(minus% 2 == 1) {
			answer += array[minus-1];
		}
		if((num - minus) % 2 == 1) {
			answer += array[minus];
		}
		
		for(int i = num -1; i > minus; i-=2) {
			int max = 0;
			int mul = array[i] * array[i-1];
			int sum = array[i] + array[i-1];
			max = Math.max(mul, sum);
			
			answer+=max;
			
		}
		
		System.out.println(answer);
	}
}
