package NQuuen;
import java.util.List;
import java.util.ArrayList;
class Solution {
    static ArrayList<int[]> list;
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result=new ArrayList<>();
        list=new ArrayList<>();
        for(int i=0; i<n; i++){
            int[] board=new int[n];
            board[0]=i;
            DFS(board,0);
        }
        for(int i=0; i<list.size(); i++){
            int[] temp=list.get(i);
            System.out.println();
            for(int j=0; j<temp.length; j++){
                System.out.print(temp[j]+" ");
            }
            System.out.println();
            ArrayList<String> stringList=new ArrayList<>();
            for(int j=0; j<temp.length; j++){
                StringBuilder sb=new StringBuilder();
                int num=temp[j];
                System.out.println(num);
                for(int k=0; k<num; k++){
                    sb.append('.');
                }
                sb.append('Q');
                for(int k=num+1; k<n; k++){
                    sb.append('.');
                }
                stringList.add(sb.toString());
            }
            result.add(stringList);
            
        }
        return result;
    }
    private void DFS(int[] array,int n){
        if(n==array.length-1){
        	int[] temp=new int[array.length];
            for(int i=0; i<array.length; i++){
            	temp[i]=array[i];
            }
            list.add(temp);
            return;
        }
        else{
            for(int i=0; i<array.length; i++){
                array[n+1]=i;
                if(possible(array,n+1)){
                    DFS(array,n+1);
                }
            }
        }
    }
    private boolean possible(int[] array,int n){
        for(int i=0; i<n; i++){
            if(array[i]==array[n]){
                return false;
            }
            if(Math.abs(i-n)==Math.abs(array[i]-array[n]))
                return false;
        }
        return true;
    }

}
public class Main {
	public static void main(String[] args) {
		int num=4;
		Solution solution=new Solution();
		List<List<String>> list=solution.solveNQueens(num);
	}

}
