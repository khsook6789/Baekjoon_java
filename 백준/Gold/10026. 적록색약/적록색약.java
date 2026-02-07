import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && nx<n && ny>=0 && ny<n){
                if(!visited[nx][ny] && graph[nx][ny]==graph[x][y]){
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        visited = new boolean[n][n];
        int rgbCount = 0;
        int rbCount = 0;

        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<n;j++){
                if(str.charAt(j)=='R'){
                    graph[i][j] = 1;
                }else if(str.charAt(j)=='G'){
                    graph[i][j] = 2;
                }else if(str.charAt(j)=='B'){
                    graph[i][j] = 3;
                }

            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    dfs(i,j);
                    rgbCount++;
                }
            }
        }
        sb.append(rgbCount).append(" ");

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(graph[i][j]==1){
                    graph[i][j] = 2;
                }
            }
        }

        visited = new boolean[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    dfs(i,j);
                    rbCount++;
                }
            }
        }
        sb.append(rbCount);

        System.out.println(sb);
    }
}