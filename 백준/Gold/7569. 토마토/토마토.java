import java.io.*;
import java.util.*;

public class Main {
    static int[][][] graph;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int m,n,h;
    static Queue<int[]> q = new LinkedList<>();

    static int bfs(){
        while(!q.isEmpty()){
            int [] cur = q.poll();
            int z = cur[0];
            int x = cur[1];
            int y = cur[2];

            for(int i=0;i<6;i++){
                int nz = z + dz[i];
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nz>=0 && nz<h && nx>=0 && nx<n && ny >=0 && ny <m){
                    if(graph[nz][nx][ny]==0){
                        graph[nz][nx][ny] = graph[z][x][y] + 1;
                        q.offer(new int[]{nz,nx,ny});
                    }
                }
            }
        }

        int day = 0;

        for(int i=0;i<h;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<m;k++){
                    if(graph[i][j][k]==0){
                        return -1;
                    }
                    day = Math.max(day, graph[i][j][k]);
                }
            }
        }
        return day-1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        graph = new int[h][n][m];

        for(int i=0; i<h; i++) {
            for(int j=0; j<n; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<m; k++) {
                    graph[i][j][k] = Integer.parseInt(st.nextToken());
                    if(graph[i][j][k] == 1) {
                        q.offer(new int[]{i, j, k});
                    }
                }
            }
        }

        System.out.println(bfs());
    }
}