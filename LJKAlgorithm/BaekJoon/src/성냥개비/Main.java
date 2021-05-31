package 성냥개비;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		Solution solution = new Solution();
		for(int tc =1; tc <= testcase; tc++) {
			int n = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			String max;
			if ( n % 2 == 1) {
				sb.append(7);
				max = sb.toString() + solution.findMax(n-3);
				
			}else {
				max = solution.findMax(n);
			}
			System.out.println(solution.findMin(n) + " " + max);
			for(int i= 2; i<=100; i++) {
				System.out.println("#"+(i-1)+" "+solution.findMin(i));
			}
			
		}
	}
}
class Solution{
	public String findMax(int n) {
		StringBuilder sb = new StringBuilder();
		for ( int i = 0 ; i < n / 2 ; i++) {
			sb.append(1);
		}
		return sb.toString();
	}
	public String findMin(int n) {
		if( n == 2) return "2";
		else if(n == 3) return "7";
		else if(n == 4) return "4";
		else if(n == 5) return "2";
		else if(n == 6) return "6";
		else if(n == 7) return "8";
		else {
			int[] num = {6, 2 , 5 , 5 , 4 , 5 , 6 , 3 , 7 , 6};
			int[] len = new int[10];
			StringBuilder sb =new StringBuilder();
			sb.append(1);
			n -= 2;
			int min = Integer.MAX_VALUE;
			int minindex = Integer.MAX_VALUE;
			List<String> list = new ArrayList<>();
			for(int i = 0; i < num.length; i++) {
				int temp = n / num[i];
				if(n % num[i] !=0) {
					temp++;
				}
				len[i] = temp ;
				min=Math.min(len[i], min);
			}
			for(int i = 0 ; i < 10; i++) {
				if(len[i] == min) {
					StringBuilder temp = new StringBuilder();
					for(int j = 0 ; j < min ; j++) {
						temp.append(i);
					}
					if( n % num[i] == 0) {
						list.add(temp.toString());
						continue;
					}else if(n % num[i] == 1 ) {
						temp.deleteCharAt(sb.length()-1);
						char[] array = (temp.toString() + findModule(n % num[i] + num[i])).toCharArray();
						Arrays.sort(array);
						temp = new StringBuilder();
						for(int j = 0 ; j < array.length; j++) {
							temp.append(array[j]);
						}
						list.add(temp.toString());
						continue;
					}
					char[] array = (temp.toString() + findModule(n % num[i])).toCharArray();
					Arrays.sort(array);
					temp = new StringBuilder();
					for(int j = 0 ; j < array.length; j++) {
						temp.append(array[j]);
					}
					list.add(temp.toString());
				}
			}
			Collections.sort(list, new Comparator<String>(){

				@Override
				public int compare(String arg0, String arg1) {
					// TODO Auto-generated method stub
					return Integer.compare(arg0.length(),arg1.length());
				}
			});
			return "1"+list.get(0);
		}
		
	}
	private String findModule(int n) {
		if( n == 2) return "2";
		else if(n == 3) return "7";
		else if(n == 4) return "4";
		else if(n == 5) return "2";
		else if(n == 6) return "0";
		else if(n == 7) return "8";
		else if(n == 8) return "01";
		else return "cant";
	}
}
