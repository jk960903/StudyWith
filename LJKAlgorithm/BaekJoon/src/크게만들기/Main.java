package 크게만들기;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int n=Integer.parseInt(st.nextToken());
		
	}
}
class Solution{
	public String solution(String num,int k) {
		String result="";
		int[] array=new int[10];
		for(int i=0; i<num.length(); i++) {
			array[num.charAt(i)-'0']++;
		}
		int index=0;
		int delete=0;
		for(int i=0; i<10; i++) {
			delete+=array[i];
			//if(delete[])
		}
		while(k!=0) {
			
		}
		return result;
	}
}
