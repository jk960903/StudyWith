package 캐슬디펜스;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			int[][] map=new int[n][m];
			int distance=Integer.parseInt(st.nextToken());
			for(int i=0; i<n; i++) {
				st=new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<m; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			Solution solution=new Solution();
			System.out.println(solution.DFS(0,0,map,new ArrayList<>(),distance));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
class Solution{
	static int max=0;
	public int DFS(int start,int depth,int[][] array,List<Integer> list,int distance) {
		if(depth==3) {
			int count=0;
			int[][] copy=new int[array.length][array[0].length];
			for(int i=0; i<copy.length; i++) {
				for(int j=0; j<copy[0].length; j++) {
					copy[i][j]=array[i][j];
				}
			}
			for(int i=0; i<array.length; i++) {
				count+=Shoot(copy,list,distance);
				array=nextTurn(copy);
			}
			max=Math.max(max,count);
			return max;
		}else {
			for( int i = start; i < array[0].length; i++) {
				list.add(i);
				DFS(i+1,depth+1,array,list,distance);
				list.remove(list.size()-1);
			}
		}
		return max;
	}
	private int[][] nextTurn(int[][] array){
		for(int i=array.length -1 ; i>=1; i--) {
			for(int j = 0; j < array[0].length; j++) {
				array[i][j]=array[i-1][j];
			}
		}
		for(int i=0; i<array[0].length; i++) {
			array[0][i]=0;
		}
		return array;
	}
	private int Shoot(int[][] array,List<Integer> list,int distance) {
		List<archer> shoot=new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			int archerx=list.get(i);
			int archery=array.length;
			int mindis=Integer.MAX_VALUE;
			int minx=array[0].length;
			int miny=array.length;
			for(int j=array.length-1;  j>=0; j--) {
				for(int k=0; k<array[0].length; k++) {
					if(array[j][k]==1 && distance >= Math.abs(archery-j) + Math.abs(archerx-k)) {
						if( Math.abs(archery-j) + Math.abs(archerx-k) <= mindis) {
							if(mindis > Math.abs(archery - j ) + Math.abs(archerx - k)) {
								mindis=Math.abs(archery - j) + Math.abs(archerx -k );
								minx=k;
								miny=j;
							}
							else if(mindis == Math.abs(archery- j) + Math.abs(archerx - k)) {
								if(minx > k) {
									minx=k;
									miny=j;
								}
							}
						}
					}
				}
			}
			if(minx != array[0].length && miny != array.length) { // 쏠수 있을경우
				boolean check=false; // 중복된 값이 있는지 판별
				for(int j=0; j<shoot.size(); j++) { // 탐색
					archer temp=shoot.get(j);
					if(minx==temp.x && miny==temp.y) {
						check=true;
					}
				}
				if(check) continue;
				shoot.add(new archer(minx,miny));
			}
		}
		for(int i=0; i<shoot.size(); i++) {
			archer archer=shoot.get(i);
			array[archer.y][archer.x]=0;
		}
		
		return shoot.size();
	}
}
class archer{
	int x;
	int y;
	int distance;
	protected archer(int x,int y){
		this.x=x;
		this.y=y;
	}
}