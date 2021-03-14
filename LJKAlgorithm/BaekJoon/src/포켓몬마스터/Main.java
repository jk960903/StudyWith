package 포켓몬마스터;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		HashMap<String,Integer> mapNum=new HashMap<>();
		HashMap<Integer,String> mapName=new HashMap<>();
		StringBuilder sb=new StringBuilder();
		for(int i=1; i<=n; i++) {
			String temp=br.readLine();
			mapNum.put(temp,i);
			mapName.put(i,temp);
		}
		for(int i=1; i<=k; i++) {
			String result="";
			String temp="";
			int a;
			try {
				temp=br.readLine();
				a=Integer.parseInt(temp);
				result=mapName.get(a);
			}catch(Exception e) {
				result=Integer.toString(mapNum.get(temp));
			}finally {
				sb.append(result+"\n");
			}
		}
		System.out.println(sb);
	}
}
