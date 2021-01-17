package 가장긴증가하는부분수열2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int a=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int[] array=new int[a];
		ArrayList<Integer> list=new ArrayList<>();
		ArrayList<int[]> list1=new ArrayList<>();
		list1.add(array);
		StringBuilder sb=new StringBuilder();
		list.add(0);
		for(int i=0; i<a; i++) {
			array[i]=Integer.parseInt(st.nextToken());
			if(array[i]>list.get(list.size()-1)) list.add(array[i]);
			else {
				int left=0;
				int right=list.size()-1;
				while(left<right) {
					int mid=(left+right)/2;
					if(list.get(mid)<array[i]) {
						left=mid+1;
					}else {
						right=mid;
					}
				}
				list.set(right, array[i]);
			}
		}
		System.out.println(list.size()-1);
	}
}
