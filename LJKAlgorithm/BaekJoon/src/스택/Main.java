package Ω∫≈√;
import java.io.*;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int pointer=-1;
		int[] stack=new int[n];
		for(int i=0; i<n; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			String order=st.nextToken();
			if(order.equals("push")) {
				pointer++;
				stack[pointer]=Integer.parseInt(st.nextToken());
			}else if(order.equals("top")) {
				if(pointer==-1) System.out.println(-1);
				else System.out.println(stack[pointer]);
			}else if(order.equals("size")) {
				System.out.println(pointer+1);
			}else if(order.equals("empty")) {
				if(pointer==-1) System.out.println(1);
				else System.out.println(0);
			}else if(order.equals("pop")) {
				if(pointer==-1)System.out.println(-1);
				else {
					System.out.println(stack[pointer]);
					pointer--;
				}
			}
		}
		
	}
}
