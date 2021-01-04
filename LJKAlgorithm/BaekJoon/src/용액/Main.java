package ฟ๋พื;
//https://www.acmicpc.net/problem/2467
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int[] liquid=new int[n];
		for(int i=0; i<n; i++) {
			liquid[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.parallelSort(liquid);
		int left=0;
		int right=liquid.length-1;
		int min=Integer.MAX_VALUE;
		int resultl=0;
		int resultr=0;
		while(left<right) {
			int sum=liquid[left]+liquid[right];
			if(Math.abs(min)>Math.abs(sum)) {
				min=sum;
				resultl=left;
				resultr=right;
			}
			if(sum<0)left++;
			else right--;
			
			
		}
		System.out.println(liquid[resultl]+" "+liquid[resultr]);
	}
}
