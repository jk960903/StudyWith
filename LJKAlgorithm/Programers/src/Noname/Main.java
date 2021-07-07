package Noname;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		String s = "aabbccddfddccbbaa";
		Solution solution = new Solution();
		String[] answer= solution.solution(s);
		for(int i = 0; i <answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}
class Solution{
	public String[] solution(String s) {
		String[] answer = {};
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		List<String> list = new ArrayList<>();
		for(int i = 0; i<=s.length()/2; i++) {
			sb1.append(s.charAt(i));
			sb2.insert(0,s.charAt(s.length()-1-i));
			if(sb1.toString().equals(sb2.toString())) {
				list.add(sb1.toString());
				sb1 = new StringBuilder();
				sb2 = new StringBuilder();
			}
			
			
		}
		if(!sb1.toString().equals(sb2.toString())) {
			list.add(sb1.toString()+sb2.toString());
			answer = new String[list.size()*2 -1];
			for(int i = 0 ; i < list.size(); i++) {
				answer[i] = list.get(i);
				answer[answer.length - 1 - i] = list.get(i);
			}
		}
		else {
			if(list.size() % 2 == 1) {
				answer = new String[list.size()*2 -1];
				for(int i = 0 ; i < list.size(); i++) {
					answer[i] = list.get(i);
					answer[answer.length - 1 - i] = list.get(i);
				}
			}
			else {
				answer = new String[list.size() * 2];
				for(int i = 0; i<list.size(); i++) {
					answer[i] = list.get(i);
					answer[answer.length - 1 - i] = list.get(i);
				}
			}
			
		}
		return answer;
	}
}
