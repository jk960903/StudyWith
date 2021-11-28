package ť;
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.parseInt(br.readLine());
			LinkedList<Integer> queue = new LinkedList<>();
			for(int i = 0; i<n; i++) {
				String s = br.readLine();
				String[] temps = s.split(" ");
				if(temps.length == 2) {
					if(temps[0].equals("push")) {
						queue.add(Integer.parseInt(temps[1]));
					}
				}else {
					if(temps[0].equals("front")) {
						if(queue.size() > 0) {
							System.out.println(queue.get(0));
						}else {
							System.out.println(-1);
						}
					}else if(temps[0].equals("back")) {
						if(queue.size() > 0) {
							System.out.println(queue.get(queue.size()-1));
						}else {
							System.out.println(-1);
						}
					}else if(temps[0].equals("size")) {
						System.out.println(queue.size());
					}else if(temps[0].equals("pop")) {
						if(queue.size() == 0) {
							System.out.println(-1);
						}else {
							int num = queue.get(0);
							queue.remove();
							System.out.println(num);
						}
					}else if(temps[0].equals("empty")) {
						if(queue.size() ==0) {
							System.out.println(1);
						}else {
							System.out.println(0);
						}
					}
				}
			}
			br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
