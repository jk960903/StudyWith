package 펠린드롬분할;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Solution solution=new Solution();
		String s=br.readLine();
		int answer=solution.PalendromDivive(s);
		System.out.println(answer);
		
	}
}
class Solution{
	public int PalendromDivive(String s) {
		int answer=0;
		for(int i = 0; i < s.length(); i++) {
			answer+=countPalendrom(s,i,i);
			answer+=countPalendrom(s,i,i+1);
		}
		return answer;
	}
	public int countPalendrom(String s,int i,int j) {
		int count=0;
		while(i >= 0 && j < s.length() && i<=j) {
			if(s.charAt(i) == s.charAt(j)) {
				count++;
				i--;
				j++;
			}else {
				break;
			}
		}
		return count;
	}
}
