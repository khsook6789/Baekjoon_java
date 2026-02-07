import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static int[][] dist;
    static int n,m;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        dist[x][y] = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i=0;i<4;i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<m){
                    if(graph[nx][ny] != 0 && dist[nx][ny] == -1){
                        dist[nx][ny] = dist[curX][curY] + 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        dist = new int[n][m];

        int startX = 0;
        int startY = 0;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = -1;
                if(graph[i][j] == 2){
                    startX = i;
                    startY = j;
                }
            }
        }
        bfs(startX, startY);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(graph[i][j]==0){
                    sb.append(0).append(" ");
                }else{
                    sb.append(dist[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}