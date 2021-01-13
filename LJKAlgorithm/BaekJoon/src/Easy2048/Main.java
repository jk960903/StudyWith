package Easy2048;
import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class Main {
	static int max=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[][] map=new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<n; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		ArrayList<Integer> list=new ArrayList<>();
		DFS(0,list,map);
		System.out.println(max);
	}
	private static void DFS(int depth,ArrayList<Integer> list,int[][] map) {
		if(depth==5) {
			int[][] copy=new int[map.length][map.length];
			for(int i=0; i<map.length; i++) {
				for(int j=0; j<map.length; j++) {
					copy[i][j]=map[i][j];
				}
			}
			Solution(copy,list);
			return;
		}
		for(int i=0; i<4; i++) {
			list.add(i);
			DFS(depth+1,list,map);
			list.remove(list.size()-1);
		}
	}
	private static void Solution(int[][] map,ArrayList<Integer> list) {
		for(int i=0; i<5; i++) {
			int type=list.get(i);
			if(type==0) {
				//위
				Queue<Integer> queue=new LinkedList<>();
				for(int k=0; k<map.length; k++) {
					for(int j=0; j<map.length; j++) {
						if(map[j][k]!=0) {
							queue.add(map[j][k]);
							map[j][k]=0;
						}
					}
					int index=0;
					if(!queue.isEmpty()) {
						while(!queue.isEmpty()) {
							int num=queue.poll();
							if(!queue.isEmpty()&&queue.peek()==num) {
								map[index][k]=num*2;
								queue.poll();
								index++;
							}else {
								map[index][k]=num;
								index++;
							}
						}
					}
				}
			}else if(type==1) {
				//오른쪽
				Queue<Integer> queue=new LinkedList<>();
				for(int j=0; j<map.length; j++) {
					for(int k=map.length-1; k>=0; k--) {
						if(map[j][k]!=0) {
							queue.add(map[j][k]);
							map[j][k]=0;
						}
					}
					int index=map.length-1;
					while(!queue.isEmpty()) {
						int num=queue.poll();
						if(!queue.isEmpty()&&queue.peek()==num) {
							map[j][index]=num*2;
							queue.poll();
							index--;
						}else {
							map[j][index]=num;
							index--;
						}
					}
				}
			}else if(type==2) {
				//아래
				Queue<Integer> queue=new LinkedList<>();
				for(int j=0; j<map.length; j++) {
					for(int k=map.length-1; k>=0; k--) {
						if(map[k][j]!=0) {
							queue.add(map[k][j]);
							map[k][j]=0;
						}
					}
					int index=map.length-1;
					while(!queue.isEmpty()) {
						int num=queue.poll();
						if(!queue.isEmpty()&&queue.peek()==num) {
							map[index][j]=num*=2;
							queue.poll();
							index--;
						}else {
							map[index][j]=num;
							index--;
						}
					}
				}
			}else {
				//왼쪽
				Queue<Integer> queue=new LinkedList<>();
				for(int j=0; j<map.length; j++) {
					for(int k=0; k<map.length; k++) {
						if(map[j][k]!=0) {
							queue.add(map[j][k]);
							map[j][k]=0;
						}
					}
					int index=0;
					while(!queue.isEmpty()) {
						int num=queue.poll();
						if(!queue.isEmpty()&&queue.peek()==num) {
							map[j][index]=num*2;
							queue.poll();
							index++;
						}else {
							map[j][index]=num;
							index++;
						}
					}
				}
			}
			
		}
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map.length; j++) {
				max=Math.max(max, map[i][j]);
			}
		}
	}
}
