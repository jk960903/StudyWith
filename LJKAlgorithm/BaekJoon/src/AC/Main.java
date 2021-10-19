package AC;
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			for(int tc=1; tc<=T; tc++) {
				Deque<Integer> deck = new LinkedList<>();
				String function = br.readLine();
				int n = Integer.parseInt(br.readLine());
				String array = br.readLine();
				boolean error = true;
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				array = array.replace("[", "");
				array = array.replace("]", "");
				String[] temp = array.split(",");
				if(n==0) {
					sb.append("[");
				}else {
					for(int i = 0 ; i<temp.length; i++) {
						deck.add(Integer.parseInt(temp[i]));
					}
					 
				}
				int now = 1;
				for(int i = 0; i<function.length(); i++) {
					char tempFun = function.charAt(i);
					if(tempFun == 'R') {
						if(now == 1) {
							now = -1;
						}else {
							now = 1;
						}
					}else {
						if(deck.size() == 0 ) {
							error = false;
							break;
						}else {
							if(now == 1) {
								deck.removeFirst();
							}else {
								deck.removeLast();
							}
						}
					}
					
				}
				if(error) {
					if(now == 1 ) {
						if(deck.isEmpty()) {
							System.out.println("[]");
							continue;
						}
						while(!deck.isEmpty()) {
							sb.append(deck.removeFirst()+",");
						}
					}else {
						if(deck.isEmpty()) {
							System.out.println("[]");
							continue;
						}
						while(!deck.isEmpty()){
							sb.append(deck.removeLast()+",");
						}
					}
					sb.deleteCharAt(sb.length()-1);
					sb.append("]");
					System.out.println(sb.toString());
				}else {
					System.out.println("error");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
