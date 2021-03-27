package 위장;
// 완전 탐색보다는 그냥 경우의 수 계산이 빠름 answer - 1이 이유는 아무것도 들어가지 않는 경우가 있을 경우
import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String,Integer> map=new HashMap<>();
        HashSet<String> set=new HashSet<>();
        int[] test=new int[100000000];
        int answer = 1;
        /*for(int i = 0; i < clothes.length; i++){
            if( map.containsKey( clothes[i][1] ) ){
                map.put( clothes[i][1] , map.get( clothes[i][1] ) + 1 );
            }else{
                map.put(clothes[i][1],1);
                set.add(clothes[i][1]);
            }
        }
        for( String s : set){
            answer *= map.get( s ) + 1;
        }*/
        return answer -1 ;
    }
}
public class Main {
	public static void main(String[] args) {
		Solution s=new Solution();
		String[][] clothes= {{}};
		int[] temp=new int[20000000];
		s.solution(clothes);
	}
}
