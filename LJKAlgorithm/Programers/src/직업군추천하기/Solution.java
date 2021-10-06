package 직업군추천하기;
import java.util.HashMap;
class solution {
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        HashMap<String,Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0; i< table.length; i++){
            String[] temp = table[i].split(" ");
            map.put(temp[0],0);
            for(int j = 1 ; j<temp.length; j++){
                for(int k = 0; k<languages.length; k++){
                    if(languages[k].equals(temp[j])){
                        map.put(temp[0],map.get(temp[0])+preference[k]*(6-j));
                    }
                }
            }
            if(map.get(temp[0])>=max){
                if(map.get(temp[0])==max&&answer.charAt(0)>temp[0].charAt(0)){
                    answer = temp[0];
                }else if(map.get(temp[0])>max){
                    max= map.get(temp[0]);
                    answer = temp[0];
                }
            }
            
        }
        return answer;
    }
}
public class Solution {

}
