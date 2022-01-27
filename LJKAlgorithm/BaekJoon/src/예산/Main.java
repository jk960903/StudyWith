package ¿¹»ê;
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
        	int n = Integer.parseInt(br.readLine());
        	StringTokenizer st = new StringTokenizer(br.readLine()," ");
        	long total = Long.parseLong(br.readLine());
        	long[] array = new long[n];
        	
        	for(int i = 0 ; i < n; i++) {
        		array[i] = Long.parseLong(st.nextToken());
        	}
        	
        	Arrays.sort(array);
        	
        	long left = array[0];
        	long right = array[n-1];
        	
        	long max = 0;
        	long answer = 0;
        	
        	while(left <= right) {
        		long mid = (left + right) / 2 ;
            	
        		long temp = 0;
        		for(int i = 0 ; i < n ; i++) {
        			if(array[i] <= mid) {
        				temp+= array[i];
        			}else {
        				temp+= mid;
        			}
        		}
        		
        		if(temp > total) {
        			right = mid-1;
        		}else {
        			left = mid+1;
        			answer = Math.max(answer, mid);
        		}
        	}
        	
        	br.close();
        	System.out.println(answer);
        	
        }catch(Exception e) {
        	e.printStackTrace();
        }
    }
}