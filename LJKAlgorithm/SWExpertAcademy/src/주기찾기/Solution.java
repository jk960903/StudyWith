package 주기찾기;
import java.io.*;
import java.util.*;
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(br.readLine());
		int index=0;
		int s,p,q,m;
		long pre;
		int cal;
		boolean[] visit;
		int[] indexarray;
		for(int testcase=1; testcase<=tc; testcase++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			s=Integer.parseInt(st.nextToken());
			p=Integer.parseInt(st.nextToken());
			q=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			visit=new boolean[m];
			indexarray=new int[m];
			cal=(int)((long)(p*s+q)%m);
			int first=cal;
			int count=1;
			visit[cal]=true;
			indexarray[cal]=index;
			index++;
			pre=(long)(p*s+q)%m;
			int num;
			while(true) {
				num=(int)((long)(p*pre+q)%m);
				pre=num;	
				if(visit[num]) {
					index=indexarray[num];
					int result=count-index;
					System.out.println("#"+testcase+" "+result);
					break;
				}else {
					visit[num]=true;
					indexarray[num]=index;
					index++;
					count++;
				}
			}
			
		}
	}
}
