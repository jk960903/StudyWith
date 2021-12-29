package ∞‘¿”;
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y= Integer.parseInt(st.nextToken());
			
			int z = getPercent(x,y);
			
			int answer = -1;
			
			int left = 0 ;
			int right = x;
			if(x == y) {
				System.out.println(-1);
				return;
			}
			while(left <= right) {
				int mid = (left + right) / 2;
				
				if(getPercent(x+mid,y+mid) != z) {
					answer = mid;
					right = mid -1;
				}else {
					left = mid + 1;
				}
				
			}
			
			System.out.println(answer);
		}catch(Exception e) {
			
		}
	}
	
	public static int getPercent(int x, int y) {
		return (int) ((long) y * 100 / x);
	}
}
