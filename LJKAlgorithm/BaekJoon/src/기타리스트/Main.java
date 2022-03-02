package ��Ÿ����Ʈ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]); //���� 
		int s = Integer.parseInt(input[1]); //����
		int m = Integer.parseInt(input[2]); // �Ӱ谪
		
		int[] dp = new int[m+1];
		int[] arrays = new int[n+1];
		
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		for(int i = 1; i < arrays.length; i++) {
			arrays[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i <dp.length; i++) {
			dp[i] = -1;
		}
		
		dp[s] = 0;
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 1 ; i < arrays.length; i++) { //���� �ε���
			list.clear();
			
			for(int j = 0 ; j <= m; j++) { //����
				if(dp[j] == i-1) {
					if(0 <= j - arrays[i] && j - arrays[i] <= m) {
						list.add(j-arrays[i]);
					}
					if(0 <= j + arrays[i] && j + arrays[i] <= m) {
						list.add(j+arrays[i]);
					}
				}
			}
			
			for(int num : list) {
				dp[num] = i;
			}
			
			
		}
		
		for(int i = m; i>=0; i--) {
			if(dp[i] ==n) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
		
		
		
		
	}
}
