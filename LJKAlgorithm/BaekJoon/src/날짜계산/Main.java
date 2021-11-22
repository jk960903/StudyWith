package 날짜계산;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int e = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int tempe = 1;
			int temps = 1;
			int tempm = 1;
			
			int result = 1;
			while(tempe != e || temps != s || tempm != m) {
				tempe++;
				temps++;
				tempm++;
				if(tempe == 16) {
					tempe = 1;

				}
				if(temps == 29 ) {
					temps = 1;
				}
				if(tempm == 20) {
					tempm = 1;
				}
				result++;
			}
			
			System.out.println(result);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
