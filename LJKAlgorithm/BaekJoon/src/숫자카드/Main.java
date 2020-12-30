package 숫자카드;
//https://www.acmicpc.net/problem/10815
import java.util.Scanner;
import java.util.HashMap;
public class Main {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		HashMap<Integer,Integer> map=new HashMap<>();
		int N=scan.nextInt();
		for(int i=0; i<N; i++) {
			int temp=scan.nextInt();
			map.put(temp,1);
		}
		int M=scan.nextInt();
		int[] array=new int[M];
		for(int i=0; i<M; i++) {
			int temp=scan.nextInt();
			if(map.containsKey(temp)) {
				array[i]=1;
			}else {
				array[i]=0;
			}
		}
		for(int i=0; i<M; i++) {
			System.out.print(array[i]+" ");
		}
	}
}
