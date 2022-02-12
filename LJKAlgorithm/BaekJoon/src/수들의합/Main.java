package 수들의합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		
		int[] arrays = new int[n];
		
		for(int i = 0; i < n ; i++) {
			arrays[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int i = 0;
		int j = 0;
		
		int count = 0 ;
		int sum = arrays[0];
		
		
		while(i < n) {
			if(sum < m) {
				j++;
				if(j == arrays.length) {
					break;
				}
				sum += arrays[j];
			}else if(sum > m) {
				sum -= arrays[i];
				i++;
			}else {
				sum-= arrays[i];
				i++;
				count++;
			}
		}
		
		System.out.println(count);
	}
}
