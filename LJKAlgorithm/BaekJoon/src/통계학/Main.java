package ≈Î∞Ë«–;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			int[] array =new int[N];
			for(int i = 0 ; i<N; i++) {
				array[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(array);
			Solution solution = new Solution();
			System.out.println(solution.Average(array));
			System.out.println(solution.Middle(array));
			System.out.println(solution.Most(array));
			System.out.println(solution.Arrange(array));
			
			
		}catch(Exception e) {
			
		}
		
	}
}
class Solution{
	public int Average(int[] array) {
		int sum = 0 ;
		for(int i = 0 ; i< array.length; i++) {
			sum += array[i];
		}
		float average = (float)sum / (float)array.length;
		
		return Math.round(average);
	}
	public int Middle(int[] array) {
		return array[array.length/2];
	}
	
	public int Most(int[] array) {
		HashMap<Integer,Integer> map = new HashMap<>();
		HashSet<Integer> set = new HashSet<>();
		int answer = 0 ;
		int max = 0 ;
		for(int i = 0 ; i<array.length; i++) {
			if(map.containsKey(array[i])) {
				int num = map.get(array[i]);
				max = Math.max(num+1, max);
				map.put(array[i],num+1);
			}else {
				map.put(array[i],1);
				set.add(array[i]);
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		if(max == 0 ) max =1;
		for(int num : set) {
			int temp = map.get(num);
			if(temp==max) {
				list.add(num);
			}
		}
		if(list.size()==1) {
			answer = list.get(0);
		}else {
			Collections.sort(list);
			answer = list.get(1);
		}
		return answer;
		
	}
	
	public int Arrange(int[] array) {
		return array[array.length-1] - array[0];
	}
}