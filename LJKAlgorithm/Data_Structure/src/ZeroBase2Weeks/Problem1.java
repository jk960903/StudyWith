package ZeroBase2Weeks;
import java.io.*;
import java.util.*;
public class Problem1 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());
			int[] array = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < n ; i++) {
				array[i] = Integer.parseInt(st.nextToken());
			}
			int checknum = Integer.parseInt(st.nextToken());
			int[] checkArray = new int[checknum];
			
			
		}catch(Exception e) {
			
		}
	}
}
