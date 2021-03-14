package ерга╥на╖ф╝;
import java.io.*;
import java.util.*;
public class Main {
	static int count=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testcase=Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		for(int i=0; i<testcase; i++) {
			int n=Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine()," ");
			int[] hope=new int[n];
			boolean[] visit=new boolean[n];
			boolean[] done=new boolean[n];
			count=0;
			for(int j=0; j<n; j++) {
				hope[j]=Integer.parseInt(st.nextToken());
			}
			for(int j=0; j<n; j++) {
				solution(j+1, visit, done, hope);
			}
			sb.append(n - count);
            sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	public static void solution(int n,boolean[] visit,boolean[] done,int[] hope) {
		if(visit[n-1]) {
			count++;
			done[n-1]=true;
		}else {
			visit[n-1]=true;
		}
		if(!done[hope[n-1]-1]) {
			solution(hope[n-1],visit,done,hope);
		}
		visit[n-1]=false;
		done[n-1]=true;
	}
}

