import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void bfs(int x,int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i=0;i<4;i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                    if(graph[nx][ny]==1 && !visited[nx][ny]){
                        q.offer(new int[]{nx,ny});
                        visited[nx][ny] = true;
                        graph[nx][ny] = graph[curX][curY] + 1;
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

        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<m;j++){
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0,0);
        System.out.println(graph[n-1][m-1]);
    }
}