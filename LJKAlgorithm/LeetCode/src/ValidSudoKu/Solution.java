package ValidSudoKu;
import java.util.HashSet;
public class Solution {
	public static void main(String[] args) {
		char[][] array={{'.','9','.','.','4','.','.','.','.'},{'1','.','.','.','.','.','6','.','.'},{'.','.','3','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','7','.','.','.','.','.'},{'3','.','.','.','5','.','.','.','.'},{'.','.','7','.','.','4','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','7','.','.','.','.'}};
		boolean check=isValidSudoku(array);
		System.out.println(check);
	}
	public static boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            HashSet<Character> xSet=new HashSet<>();//세로 판단
            HashSet<Character> ySet=new HashSet<>();//가로 판단
            for(int j=0; j<9; j++){
                if(xSet.contains(board[j][i])) return false;
                else{
                    if(board[j][i]=='.') continue;
                    xSet.add(board[j][i]);
                }
            }
            for(int j=0; j<9; j++){
                if(ySet.contains(board[i][j]))return false;
                else{
                    if(board[i][j]=='.'){
                        continue;
                    }
                    ySet.add(board[i][j]);
                }
            }
        }
        for(int i=0; i<9; i++){
            HashSet<Character> arraySet =new HashSet<>();
            for(int j=i/3*3; j<(i/3)*3+3; j++) {
                for(int k=i%3*3; k<(i%3)*3+3; k++){
                    if(arraySet.contains(board[j][k]))return false;
                    if(board[j][k]=='.') continue;
                    arraySet.add(board[j][k]);
                }
            }
        }
        return true;
    }
}
