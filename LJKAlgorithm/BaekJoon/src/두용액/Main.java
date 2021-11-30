package µÎ¿ë¾×;
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int[] array = new int[n];
			for(int i = 0 ; i < n; i ++) {
				array[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(array);
			int min = Integer.MAX_VALUE;
			int result1 = 0;
			int result2 = 0;
			int i = 0 ;
			int j = array.length-1;
			while(i < j) {
				int sum = array[i] + array[j];
				int temp = Math.abs(array[i] + array[j]);
				if(temp < min) {
					min = temp;
					result1 = array[i];
					result2 = array[j];
					
				}
				if(sum > 0) {
					j--;
				}else {
					i++;
				}
			}
			
			System.out.println(result1 + " " + result2);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
