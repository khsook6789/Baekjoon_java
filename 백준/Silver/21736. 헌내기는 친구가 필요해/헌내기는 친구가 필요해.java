import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int count = 0;

    public static void dfs(int x, int y, int n, int m){
        visited[x][y] = true;

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<n && ny<m){
                if(!visited[nx][ny] && map[nx][ny] != 0){
                    if(map[nx][ny]==2){
                        count++;
                        dfs(nx, ny, n, m);
                    }else if(map[nx][ny]==1){
                        dfs(nx, ny, n, m);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        int startX = 0;
        int startY = 0;

        for(int i=0;i<n;i++){
            String[] str = br.readLine().split("");
            for(int j=0;j<m;j++){
                if(str[j].equals("O")){
                    map[i][j] = 1; // 빈 공간
                }else if(str[j].equals("X")){
                    map[i][j] = 0; // 벽
                }else if(str[j].equals("P")){
                    map[i][j] = 2; // 사람
                }else if(str[j].equals("I")){
                    startX = i;
                    startY = j;
                    map[i][j] = 1;
                }
            }
        }

        dfs(startX, startY, n, m);

        if(count == 0){
            System.out.println("TT");
        }else{
            System.out.println(count);
        }
    }
}