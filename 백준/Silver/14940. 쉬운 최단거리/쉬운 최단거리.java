import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int n,m;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] result;

    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[]{x,y});

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i=0;i<4;i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<m){
                    if(!visited[nx][ny] && graph[nx][ny]==1){
                        visited[nx][ny] = true;
                        result[nx][ny] = result[cur[0]][cur[1]] + 1;
                        q.offer(new int[]{nx,ny});
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
        visited = new boolean[n][m];
        result = new int[n][m];

        int startX = 0;
        int startY = 0;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 2){
                    startX = i;
                    startY = j;
                }else if(graph[i][j]==0){
                    visited[i][j] = true;
                }
            }
        }
        bfs(startX, startY);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]){
                    result[i][j] = -1;
                }
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}