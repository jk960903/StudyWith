package 카카오머니;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long m = 0;
		long remain = 0;
		int n = Integer.parseInt(br.readLine());
		long minOut = Long.MAX_VALUE;
		boolean valid = true;
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			long first = Long.parseLong(st.nextToken());
			
			long second = Long.parseLong(st.nextToken());
			
			
			if(remain + first < 0) { // 현재 잔액에서 출금하였는데 음수가 나올경우
				long temp = second - first - remain;
				
				if( second != 0 && second < minOut) {
					minOut = second;
				}
				if(m == 0) {
					m = temp;
				}else {
					m = GCD(m,temp);
					
					if(m <= minOut && minOut != (long)10e18) {
						valid = false;
						break;
					}
				}
				
			}else {
				if( remain + first != second) {
					valid = false;
					break;
				}
			}
			
			remain = second;
		}
		
		if(valid && m != 0) {
			System.out.println(m);
		}else if(valid && m == 0) {
			System.out.println(1);
		}else {
			System.out.println(-1);
		}
		
		br.close();
		
	}
	
	private static long GCD(long a, long b) {
		while( b > 0 ) {
			long temp = a;
			a = b;
			b = temp % b;
		}
		
		return a;
	}
}
