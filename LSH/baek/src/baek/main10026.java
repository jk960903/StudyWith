package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Point{
	int x;
	int y;
	Point(int x, int y){
		this.x=x;
		this.y=y;
	}
}



public class main10026 {
	static int[] dx= {0,0,-1,1};	//�����¿�
	static int[] dy= {1,-1,0,0};
	static int N;
	static char[][] img;
	static boolean[][] visited;
	static Queue<Point> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		img = new char[N][N];
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				visited[i][j]=false;
			}
		}
		q = new LinkedList<Point>();
		
		for(int i=0;i<N;i++) {
			char[] line = br.readLine().toCharArray();
			for(int j=0;j<N;j++) {
				img[i][j]=line[j];
			}
		}
		int a=bfs();
		System.out.println(a);
		
	}
	
	public static int bfs() {
		//System.out.println("�Լ�����");
		int count=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visited[i][j]) {
					continue;	//�湮�� ���̸� �� �κ��� �ǳʶٱ�
				}
				visited[i][j]=true;		//�װ� �ƴ϶�� �湮���� �ٲٱ�
				q.add(new Point(i,j));
				
				while(q.isEmpty()==false) {	//ť�� ���� �ִµ���
					Point temp = q.poll(); 		//ť ���� �տ����� �ӽ� ����Ʈ������ �޾���
					
					for(int k=0;k<4;k++) {
						int temp_x=temp.x+dx[k];
						int temp_y=temp.y+dy[k];
						
						if(!isRange(temp_x,temp_y) || visited[temp_x][temp_y] || img[i][j]!=img[temp_x][temp_y]) {	//������ �ְ� �湮���߰� �������� ���ٸ�
							continue;
						}
						visited[temp_x][temp_y]=true;
						q.add(new Point(temp_x,temp_y));
						
					}
				}
				count++;
			}
		}
		return count;
		
	}
	
	public static boolean isRange(int x, int y) {
		if(x<0 || y<0 || x>=N || y>=N) return false;
		return true;
	}

}
