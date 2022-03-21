package first;
import java.util.*;
class Solution {
    public String[] solution(String[] goods) {
        String[] answer = {};
        HashSet<String> set = new HashSet<>();
        List<String>[] lists = new ArrayList[goods.length];
        for(int i = 0 ; i < goods.length; i++){
            lists[i] = new ArrayList<>();
            for(int j = 0 ; j < goods[i].length(); j++){
            	StringBuilder sb = new StringBuilder();
                sb.append(goods[i].charAt(j));
                
                for(int k = j+1; k < goods[i].length(); k++){
                    for(int l = 0; l < goods.length; l++){
                        if(l == i) continue;
                        if(goods[l].contains(sb.toString())){
                            set.add(sb.toString());
                            break;
                        }
                    }
                    if(set.contains(sb.toString())){
                        sb.append(goods[i].charAt(k));
                        if(k == goods[i].length() - 1) {
                        	boolean check = true;
                        	for(int l = 0; l < goods.length; l++){
                                if(l == i) continue;
                                if(goods[l].contains(sb.toString())){
                                    set.add(sb.toString());
                                    check = false;
                                    break;
                                }
                            }
                        	if(check) {
                        		if(lists[i].size() == 0){
                                    lists[i].add(sb.toString());
                                    break;
                                }else{
                                    String temp = lists[i].get(0);
                                    if(sb.toString().length() == temp.length()){
                                        lists[i].add(sb.toString());
                                        break;
                                    }else if(sb.toString().length() < temp.length()){
                                        lists[i] = new ArrayList<>();
                                        lists[i].add(sb.toString());
                                    }else{
                                        break;
                                    }
                                }
                        	}
                        	
                        }
                    }else{
                        if(lists[i].size() == 0){
                            lists[i].add(sb.toString());
                            break;
                        }else{
                            String temp = lists[i].get(0);
                            if(sb.toString().length() == temp.length()){
                                lists[i].add(sb.toString());
                                break;
                            }else if(sb.toString().length() < temp.length()){
                                lists[i] = new ArrayList<>();
                                lists[i].add(sb.toString());
                                break;
                            }else{
                                break;
                            }
                        }
                    }
                }
            }
        }
        answer = new String[goods.length];
        for(int i = 0 ; i < goods.length; i++) {
        	List<String> list = lists[i];
        	if(list.size() == 0) {
        		answer[i] = "None";
        		continue;
        	}
        	HashSet<String> tempSet = new HashSet<>();
        	for(String s : list) {
        		tempSet.add(s);
        	}
        	list = new ArrayList<>();
        	for(String s : tempSet) {
        		list.add(s);
        	}
        	Collections.sort(list);
        	StringBuilder sb = new StringBuilder();
        	for(String s : list) {
        		sb.append(s+" ");
        	}
        	sb.deleteCharAt(sb.length()-1);
        	answer[i] = sb.toString();
        }
        
        return answer;
    }
}
public class Main {
	public static void main(String[] args) {
		String[] goods = {"pencil","cilicon","contrabase","picturelist"};
		
		Solution solution = new Solution();
		
		String[] answer = solution.solution(goods);
		for(int i = 0 ; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}
