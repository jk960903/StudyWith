package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main15904 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line="";
		try {
			line = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		char[] target = {'U','C','P','C'};
		int index = 0;
		
		try {
			for(int i=0;i<line.length();i++) {
				if(line.charAt(i)==target[index]) {
					index++;
				}
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			
		}
		if(index==4) {
			System.out.println("I love UCPC");
		}
		else{
			System.out.println("I hate UCPC");
		}
	}
}
