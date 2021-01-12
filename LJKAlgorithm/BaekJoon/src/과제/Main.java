package 과제;
import java.io.*;
import java.util.StringTokenizer;
import java.util.Comparator;
import java.util.Arrays;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[][] subject=new int[n][2];
		for(int i=0; i<n; i++) {//과제 마감 일수까지 남은일수 w 과제점수 하루에 하나씩 할수있음
 			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			subject[i][0]=Integer.parseInt(st.nextToken());
			subject[i][1]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(subject,new Comparator<int[]>(){
			@Override
			public int compare(int[] o1,int[] o2) {
				return Integer.compare(o2[1], o1[1]);
			}
		});
		int[] score=new int[1001];
		for(int i=0; i<n; i++) {
			for(int j=subject[i][0]-1; j>=0; j--) {
				if(score[j]==0) {
					score[j]=subject[i][1];
					break;
				}
			}
		}
		int max=0;
		for(int num : score) {
			max+=num;
		}
		System.out.println(max);
		br.close();
		
		
		
	}
}
