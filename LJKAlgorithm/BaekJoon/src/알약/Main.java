package ¾Ë¾à;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt( br.readLine() );
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] array=new int[n];
		for(int i=0; i<n; i++) {
			array[i]= Integer.parseInt(st.nextToken());
		}
		Arrays.sort(array);
		int answer=0;
		for(int i=0; i<array.length /2 ; i++) {
			int temp=array[ array.length -1 -i] - array[i];
			answer+=temp;
		}
		if(array.length % 2 == 1) {
			answer+=array[n/2];
		}
		System.out.println(answer);
	}
}
