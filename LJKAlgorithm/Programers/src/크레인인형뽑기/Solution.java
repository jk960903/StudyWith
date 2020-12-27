package 크레인인형뽑기;

import java.util.ArrayList;
public class Solution {
	public static void main(String[] args) {
		int[][] board= {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves= {1,5,3,5,1,2,1,4};
		int answer=solution(board,moves);
	}
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0; i<moves.length; i++){
            int x=moves[i];
            for(int j=0; j<board.length; j++){
                if(board[j][x-1]!=0){
                    list.add(board[j][x-1]);
                    board[j][x-1]=0;
                    break;
                }
            }
            if(list.size()>=2){
                int one=list.get(list.size()-1);
                int two=list.get(list.size()-2);
                if(one==two){
                    answer+=2;
                    list.remove(list.size()-1);
                    list.remove(list.size()-1);
                }
            }
            
        }
        return answer;
    }
}