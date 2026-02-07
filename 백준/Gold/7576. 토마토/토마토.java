import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static int n,m;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static Queue<int[]> q = new LinkedList<>();
    static int day = 0;

    static int bfs(){
        while(!q.isEmpty()){
            int [] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    if(graph[nx][ny]==0){
                        graph[nx][ny] = graph[x][y] + 1;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(graph[i][j]==0){
                    return -1;
                }
                day = Math.max(day, graph[i][j]);
            }
        }

        return day-1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        graph = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j]==1){
                    q.offer(new int[]{i,j});
                }
            }
        }

        System.out.println(bfs());
    }
}