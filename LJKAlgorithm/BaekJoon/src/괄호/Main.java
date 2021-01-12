package °ýÈ£;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int n=Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			char[] temp=br.readLine().trim().toCharArray();
			if(temp.length%2==1) {
				sb.append("NO\n");
			}else {
				boolean check=false;
				int pointer=-1;
				for(int j=0; j<temp.length; j++) {
					if(temp[j]=='(') {
						pointer++;
					}else {
						if(pointer==-1) {
							sb.append("NO\n");
							check=true;
							break;
						}else {
							pointer--;
						}
					}
				}
				if(pointer!=-1) sb.append("NO\n");
				else if(!check&&pointer==-1)sb.append("YES\n");
			}
		}
		System.out.println(sb);
	}
}
