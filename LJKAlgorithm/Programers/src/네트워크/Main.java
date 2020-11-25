package 네트워크;
import java.util.Queue;
import java.util.LinkedList;
public class Main {
	public static void main(String[] args) {
		int n=3;
		int[][] computers= {{1,1,0},{1,1,0},{0,0,1}};
		Solution solution=new Solution();
		int answer=solution.solution(n, computers);
		System.out.println(answer);
	}
}
//BFS 사용 추후 DFS 사용도 올릴예정
//DFS BFS 를 사용하여 연결 네트워크 몇개인지 보는 문제 
class Solution {
  public int solution(int n, int[][] computers) {
      int answer = 0;
      boolean[][] visit=new boolean[n][n];
      for(int i=0; i<n; i++){
          if(!visit[i][i]){
          	visit[i][i]=true;
      		Queue<dot> queue=new LinkedList<>();
      		queue.add(new dot(i,i));
              answer++;
              while(!queue.isEmpty()){
                  dot d=queue.poll();
                  for(int j=0; j<n; j++){
                      if(!visit[d.x][j]&&computers[d.x][j]==1){
                          visit[d.x][j]=true;
                          visit[j][d.x]=true;
                          queue.add(new dot(j,d.x));
                      }
                  }
              }
          }
          
      }
      return answer;
  }
  class dot{
      int x;
      int y;
      protected dot(int x,int y){
          this.x=x;
          this.y=y;
      }
  }
}
