package 숫자카드2;
//https://www.acmicpc.net/problem/10816
import java.util.Scanner;
import java.util.LinkedHashMap;
public class Main {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int[] map=new int[20000001];
		for(int i=0; i<n; i++) {
			int temp=scan.nextInt(); 
			map[temp+10000000]++;
		}
		int m=scan.nextInt();
		StringBuilder sb=new StringBuilder();
		for(int i=0; i<m; i++) {
			int temp=scan.nextInt();
			sb.append(map[temp+10000000]+" ");
		}
		System.out.println(sb);
		/*LinkedHashMap<Integer,Integer> map=new LinkedHashMap<>();
		for(int i=0; i<n; i++) {
			int num=scan.nextInt();
			if(map.containsKey(num)) {
				int temp=map.get(num);
				map.put(num,temp+1);
			}else {
				map.put(num,1);
			}
		}
		int m=scan.nextInt();
		StringBuilder sb=new StringBuilder();
		for(int i=0; i<m; i++) {
			int num=scan.nextInt();
			if(map.containsKey(num)) {
				sb.append(map.get(num)+" ");
			}else {
				sb.append(0+" ");
			}
		}
		System.out.println(sb);*/
	}
	
}
