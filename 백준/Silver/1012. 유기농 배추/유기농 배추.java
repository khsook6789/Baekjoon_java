import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int [][] map;
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};

    public static void dfs(int x, int y, int M, int N){
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && ny>=0 && nx<M && ny<N){
                if(map[nx][ny]==1 && !visited[nx][ny]){
                    dfs(nx, ny, M, N);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            int count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            visited = new boolean[M][N];
            map = new int[M][N];

            for(int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            for(int i=0;i<M;i++){
                for(int j=0;j<N;j++){
                    if(map[i][j] == 1 && !visited[i][j]){
                        dfs(i,j, M, N);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}