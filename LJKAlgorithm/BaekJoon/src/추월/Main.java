package Ãß¿ù;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.io.IOException;
import java.util.LinkedHashMap;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		LinkedHashMap<String,Integer> input=new LinkedHashMap<>();
		LinkedHashSet<String> carNum=new LinkedHashSet<>();
		int[] output=new int[n];
		for(int i=0; i<n; i++) {
			String temp=br.readLine();
			input.put(temp,i);
			carNum.add(temp);
		}
		for(int i=0; i<n; i++) {
			String temp=br.readLine();
			output[i]=input.get(temp);
		}
		int answer=0;
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				if(output[i]>output[j]) {
					answer++;
					break;
				}
			}
		}
		System.out.println(answer);
	}
}
