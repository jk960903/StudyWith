package 불량사용자;
import java.util.*;
public class Solution {
    Set<Set<String>> result;
    public int solution(String[] user_id, String[] banned_id) {
        result=new HashSet<>();
        DFS(user_id,banned_id,new LinkedHashSet<>());
        return result.size();
    }
    private void DFS(String[] user_id,String[] banned_id,Set<String> set){
        if(set.size()==banned_id.length){
            if(isBanned(set,banned_id)){
                result.add(new HashSet<>(set));
            }
            return;
        }else{
            for(String s : user_id){
                if(!set.contains(s)){
                    set.add(s);
                    DFS(user_id,banned_id,set);
                    set.remove(s);
                }
            }
        }
    }
    private boolean isBanned(Set<String> set,String[] banned_id){
        int i=0;
        for(String s: set){
            if(!isSame(s,banned_id[i++])){
                return false;
            }
        }
        return true;
    }
    private boolean isSame(String a,String b){
        if(a.length()!=b.length()) return false;
        for(int i=0; i<a.length(); i++){
            if(b.charAt(i)=='*') continue;
            if(a.charAt(i)!=b.charAt(i))return false;
        }
        return true;
    }
}