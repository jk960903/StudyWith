package С§Че;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		HashMap<Integer,Integer> map=new HashMap<>();
		//HashMap<Integer,Integer> allMap=new HashMap<>();
		
		for(int i=0; i<n; i++) {
			String cal=br.readLine();
			if(cal.equals("all")) {
				for(int j=1; j<=20; j++) {
					map.put(j,1);
				}
				continue;
			}else if(cal.equals("empty")) {
				map=new HashMap<>();
				continue;
			}
			String[] temp=cal.split(" ");
			String tempcal=temp[0];
			int num=Integer.parseInt(temp[1]);
			if(tempcal.equals("add")) {
				map.put(num,1);
			}else if(tempcal.equals("check")) {
				if(map.containsKey(num)) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
			}else if(tempcal.equals("remove")) {
				if(map.containsKey(num)) {
					map.remove(num);
				}else {
					continue;
				}
			}else if(tempcal.equals("toggle")) {
				if(map.containsKey(num)) {
					map.remove(num);
				}else {
					map.put(num,1);
				}
			}
		}
	}
}
