package º¸¹°;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());
			int[] array1 = new int[n];
			int[] array2= new int[n];
			StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
			StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
			for(int i = 0 ; i < n; i++) {
				array1[i]=Integer.parseInt(st1.nextToken());
				array2[i]=Integer.parseInt(st2.nextToken());	
			}
			Arrays.sort(array1);
			Arrays.sort(array2);
			int answer = 0;
			for(int i = 0; i < n; i++) { 
				answer += array1[i]*array2[array2.length-1-i];
			}
			System.out.println(answer);
			br.close();
		}catch(Exception e) {
			
		}
	}
}
