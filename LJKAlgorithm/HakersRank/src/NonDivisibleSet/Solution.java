package NonDivisibleSet;

public class Solution {
	public static void main(String[] args) {
		String temp="278 576 496 727 410 124 338 149 209 702 282 718 771 575 436";
		String[] temp1=temp.split(" ");
		int[] array=new int[temp1.length];
		for(int i=0; i<temp1.length; i++) {
			array[i]=Integer.parseInt(temp1[i]);
		}
		int k=7; 
		int answer=nonDivisibleSubset(k,array);
		System.out.println(answer);
	}
	public static int nonDivisibleSubset(int k, int[] s) {
	    // Write your code here
	        int[] module=new int[k];
	        for(int i=0; i<s.length; i++){
	            int num=s[i]%k;
	            module[num]++;
	        }
	        int result=0;
	        if(module[0]>0) {
	        	result++;
	        }
	        for(int i=1; i<=module.length/2; i++) {
	        	if(k%2==0&&k/2==i) continue;
	        	int choice=Math.max(module[i],module[k-i]);
	        	result+=choice;
	        }
	        if(k%2==0&&module[k/2]>0) {
	        	result++;
	        }
	        return result;
	        
	        
	}
}
	
