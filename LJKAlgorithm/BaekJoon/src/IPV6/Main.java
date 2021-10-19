package IPV6;

import java.io.*;
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String input = br.readLine();
			StringBuilder sb = new StringBuilder();
			if(input.contains("::")) {
				String[] array = input.split("::");
				String[] temp1 = {};
				String[] temp2 = {};
				int count = 0 ;
				if(array[0].contains(":")) {
					temp1 = array[0].split(":");
					for(int i = 0 ; i <temp1.length; i++) {
						if(temp1[i].length()<4) {
							String temp = "";
							while(temp.length()+temp1[i].length()!=4) {
								temp+="0";
							}
							sb.append(temp+temp1[i]);
							sb.append(":");
						}
					}
				}else {
					if(array[0].length() < 4) {
						String temp = "";
						while(temp.length()+array[0].length()!=4) {
							temp+="0";
						}
						sb.append(temp+array[0]);
						sb.append(":");
						count++;
					}
				}
				StringBuilder sb1 = new StringBuilder();
				if(array[1].contains(":")) {
					temp2 = array[1].split(":");
					for(int i = 0 ; i<temp2.length; i++) {
						if(temp2[i].length() < 4) {
							String temp = "";
							while(temp.length()+temp2[i].length()!=4) {
								temp+="";
							}
							sb1.append("temp"+temp1[i]);
							sb.append(":");
						}
					}
				}else {
					if(array[1].length() < 4) {
						String temp = "";
						while(temp.length()+array[1].length()!=4) {
							temp+="0";
						}
						
						sb1.append(temp+array[1]);
						sb1.append("");
						count++;
					}
				}
				
				while(temp1.length+temp2.length+count !=8) {
					sb.append("0000:");
					count++;
				}
				
				String result = sb.toString()+sb1.toString();
				
				System.out.println(result);
			}
			else {
				String[] array = input.split(":");
				
				
				for(int i = 0 ; i<array.length; i++) {
					if(array[i].length() <4) {
						String temp = "";
						while(temp.length()+array[i].length() != 4) {
							temp+="0";
						}
						sb.append(temp+array[i]);
					}else {
						sb.append(array[i]);
					}
					sb.append(":");
					
				}
				sb.deleteCharAt(sb.length()-1);
				System.out.println(sb.toString());
			}
			
		}catch(Exception e) {
			
		}
	}
}
