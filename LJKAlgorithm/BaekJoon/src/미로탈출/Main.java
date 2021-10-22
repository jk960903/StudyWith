import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        Pair start = new Pair(Integer.parseInt(input[0]), Integer.parseInt(input[1]), 0, 0);
        input = br.readLine().split(" ");
        Pair end = new Pair(Integer.parseInt(input[0]), Integer.parseInt(input[1]), 0, 0);

        map = new int[N+1][M+1];

        for(int i=1; i<=N; i++) {
            input = br.readLine().split(" ");

            for(int j=1; j<=M; j++) {
                map[i][j] = Integer.parseInt(input[j-1]);
            }
        }

        bfs(start, end);
    }

    public static void bfs(Pair start, Pair end) {
        Queue<Pair> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[N+1][M+1][2];
        visited[start.x][start.y][0] = true;
        queue.add(new Pair(start.x, start.y, 0, 0));

        while(!queue.isEmpty()) {
            Pair temp = queue.poll();

            if(temp.x==end.x && temp.y==end.y) {
                System.out.println(temp.t);
                return;
            }

            for(int i=0; i<4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(nx<1 || nx>N || ny<1 || ny>M || visited[nx][ny][temp.f]) continue;

                if(map[nx][ny]==1 && temp.f==0) {
                    visited[nx][ny][temp.f] = true;
                    queue.add(new Pair(nx, ny, temp.t+1, 1));
                }

                else if(map[nx][ny]==0) {
                    visited[nx][ny][temp.f] = true;
                    queue.add(new Pair(nx, ny, temp.t+1, temp.f));
                }
            }
        }

        System.out.println(-1);
    }

    public static class Pair {
        int x;
        int y;
        int t;
        int f;

        public Pair(int x, int y, int t, int f) {
            this.x = x;
            this.y = y;
            this.t = t;
            this.f = f;
        }
    }
}