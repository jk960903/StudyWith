package 나무재테크;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.ArrayList;
public class Main {
	static int[][] dir= {{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1}};
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int m=scan.nextInt();
		int K=scan.nextInt();
		
		int[][] map=new int[n][n];
		int[][] feed=new int[n][n];
		PriorityQueue<wood> queue=new PriorityQueue<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j]=5;
				feed[i][j]=scan.nextInt();
			}
		}
		for(int i=0; i<m; i++) {
			int x=scan.nextInt();
			int y=scan.nextInt();
			int z=scan.nextInt();
			queue.add(new wood(x-1,y-1,z));
		}
		ArrayList<wood> die=new ArrayList<>();
		ArrayList<wood> breed=new ArrayList<>();
		for(int i=0; i<K; i++) {
			for(int j=0; j<4; j++) {
				if(j==0) {//봄
					int size=queue.size();
					PriorityQueue<wood> newqueue=new PriorityQueue<>();
					for(int k=0; k<size; k++) {
						wood temp=queue.poll();
						int tx=temp.x;
						int ty=temp.y;
						if(map[tx][ty]<temp.age) {
							die.add(new wood(tx,ty,temp.age));
							continue;
						}
						map[tx][ty]-=temp.age;
						newqueue.add(new wood(tx,ty,temp.age+1));
						
						if((temp.age+1)%5==0) {
							breed.add(new wood(tx,ty,temp.age+1));
						}
					}
					queue=new PriorityQueue<>(newqueue);
				}else if(j==1) {//여름
					for(int k=0; k<die.size(); k++) {
						wood temp=die.get(k);
						int tx=temp.x;
						int ty=temp.y;
						int age=temp.age;
						map[tx][ty]+=age/2;
					}
					die=new ArrayList<>();
				}else if(j==2) {//가을
					for(int k=0; k<breed.size(); k++) {
						wood temp=breed.get(k);
						int tx=temp.x;
						int ty=temp.y;
						int age=temp.age;
						for(int l=0; l<dir.length; l++) {
							int tempx=tx+dir[l][0];
							int tempy=ty+dir[l][1];
							if(inbound(tempx,tempy,map)) {
								queue.add(new wood(tempx,tempy,1));
							}
						}
					}
					breed=new ArrayList<>();
				}else {//겨울
					for(int k=0; k<n; k++) {
						for(int l=0; l<n; l++) {
							map[k][l]+=feed[k][l];
						}
					}
				}
			}
		}
		int answer=queue.size();
		System.out.println(answer);
		
		
	}
	static boolean inbound(int x,int y,int[][] map) {
		if(x<0||y<0||x>=map.length||y>=map[0].length) return false;
		else return true;
	}
}
class wood implements Comparable<wood>{
	int x;
	int y;
	int age;
	
	public wood(int x,int y,int age) {
		this.x=x;
		this.y=y;
		this.age=age;
	}
	@Override
	public int compareTo(wood o) {
		return this.age-o.age;
	}
}
