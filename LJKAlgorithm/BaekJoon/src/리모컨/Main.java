package ¸®¸ðÄÁ;
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int m=Integer.parseInt(br.readLine());
		boolean[] error=new boolean[10];
		if(m!=0) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int i=0; i<m; i++) {
				int num=Integer.parseInt(st.nextToken());
				error[num]=true;
			}
		}
		Solution solution=new Solution();
		int result=solution.solution(error,n);
		System.out.println(result);
	}
}
class Solution{
	public int solution(boolean[] error,int n) {
		if(n==100) return 0;
		int answer=Math.abs(n-100);
		int count=0;
		for(int i=0; i<1000000; i++) {
			int num=i;
			int len=possible(error,i);
			if(len>0) {
				count=Math.abs(num-n);
				if(answer>len+count) {
					answer=len+count;
				}
			}
		}
		return answer;
	}
	public int possible(boolean[] error,int n) {
		if(n==0) {
			if(error[0])return 0;
			else return 1;
		}
		int answer=0;
		while(n>0) {
			if(error[n%10])return 0;
			answer+=1;
			n/=10;
		}
		return answer;
	}
}
