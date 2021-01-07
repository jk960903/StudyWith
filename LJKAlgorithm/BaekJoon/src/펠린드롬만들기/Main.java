package 펠린드롬만들기;
//https://www.acmicpc.net/problem/1213
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		char[] array=s.toCharArray();
		int[] count=new int[26];
		for(int i=0; i<s.length(); i++) {
			int num=array[i]-'A';
			count[num]++;
		}
		int countodd=0;
		StringBuilder sb=new StringBuilder();
		if(s.length()%2!=0) {
			int oddpoint=-1;
			for(int i=0; i<26; i++) {
				if(count[i]%2!=0) {
					countodd++;
					oddpoint=i;
				}
				if(countodd==2) {
					System.out.println("I'm Sorry Hansoo");
					return;
				}
			}
			int mid=oddpoint+'A';
			count[oddpoint]--;
			char midchar=(char)mid;
			for(int i=0; i<26; i++) {
				int num=count[i]/2;
				count[i]/=2;
				int point=i+'A';
				char temp=(char)point;
				for(int j=0; j<num; j++) {
					sb.append(temp);
				}
			}
			sb.append(midchar);
			for(int i=25; i>=0; i--) {
				int num=count[i];
				int point=i+'A';
				char temp=(char)point;
				for(int j=0; j<num; j++) {
					sb.append(temp);
				}
			}
		}else {
			for(int i=0; i<26; i++) {
				if(count[i]%2!=0) {
					System.out.println("I'm Sorry Hansoo");
					return;
				}
			}
			
			for(int i=0; i<26; i++) {
				int num=count[i]/2;
				count[i]/=2;
				int point=i+'A';
				char temp=(char)point;
				for(int j=0; j<num; j++) {
					sb.append(temp);
				}
			}
			for(int i=25; i>=0; i--) {
				int num=count[i];
				int point=i+'A';
				char temp=(char)point;
				for(int j=0; j<num; j++) {
					sb.append(temp);
				}
			}
		}
		System.out.println(sb);
		
	}
}
