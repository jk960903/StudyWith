package IPV6;

import java.io.*;

/*
 * 반례좀 찾아주세요 ㅠ
 * 
 */
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String input = br.readLine();
			StringBuilder sb = new StringBuilder();
			if(input.equals("::")) {
				System.out.println("0000:0000:0000:0000:0000:0000:0000:0000");
				return;
			}
			if(input.contains("::")) {
				String[] array = input.split("::");
				String[] temp1 = {};
				String[] temp2 = {};
				int count = 0 ;
				
				if(array[0].contains(":")) {
					temp1 = array[0].split(":");
					for(int i = 0 ; i <temp1.length; i++) {
						if(temp1[i].length()<4) {
							int counts = 0;
							while(counts+temp1[i].length()!=4) {
								counts++;
								sb.append("0");
							}
							sb.append(temp1[i]);
							sb.append(":");
							count++;
						}else {
							sb.append(temp1[i]);
							sb.append(":");
							count++;
						}
					}
				}else {
					if(array[0].length() < 4) {
						int counts = 0;
						while(counts+array[0].length()!=4) {
							sb.append("0");
							counts++;
						}
						sb.append(array[0]);
						sb.append(":");
						count++;
					}
					else {
						sb.append(array[0]);
						sb.append(":");
						count++;
					}
				}
				StringBuilder sb1 = new StringBuilder();
				if(array.length==1) {
					while(count+array.length<=8) {
						sb1.append("0000:");
						count++;
					}
					sb1.deleteCharAt(sb1.length()-1);
					System.out.println(sb.toString()+sb1.toString());
					return;
				}
				else if(array[1].contains(":")) {
					temp2 = array[1].split(":");
					for(int i = 0 ; i<temp2.length; i++) {
						if(temp2[i].length() < 4) {
							int counts = 0;
							while(counts+temp2[i].length()!=4) {
								sb1.append("0");
								counts++;
							}
							sb1.append(temp2[i]);
							sb1.append(":");
							count++;
						}else {
							sb1.append(temp2[i]);
							sb1.append(":");
							count++;
						}
					}
				}else {
					if(array[1].length() < 4) {
						int counts = 0;
						while(counts+array[1].length()!=4) {
							sb1.append("0");
							counts++;
						}
						
						sb1.append(array[1]);
						count++;
					}else {
						sb1.append(array[1]);
						count++;
					}
				}
				
				while(count !=8) {
					sb.append("0000:");
					count++;
				}
				if(sb1.charAt(sb1.length()-1)==':') {
					sb1.deleteCharAt(sb1.length()-1);
				}
				String result = sb.toString()+sb1.toString();
				
				System.out.println(result);
			}
			else {
				String[] array = input.split(":");
				
				
				for(int i = 0 ; i<array.length; i++) {
					if(array[i].length() <4) {
						int counts = 0;
						while(counts+array[i].length() != 4) {
							sb.append("0");
							counts++;
						}
						sb.append(array[i]);
					}else {
						sb.append(array[i]);
					}
					sb.append(":");
					
				}
				sb.deleteCharAt(sb.length()-1);
				System.out.println(sb.toString());
			}
			br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
