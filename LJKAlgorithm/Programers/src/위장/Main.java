package ����;
// ���� Ž�����ٴ� �׳� ����� �� ����� ���� answer - 1�� ������ �ƹ��͵� ���� �ʴ� ��찡 ���� ���
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
