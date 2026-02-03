import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int count = 0;
    static int n, m;

    public static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<n && ny<m){
                if(!visited[nx][ny]){
                    switch(map[nx][ny]){
                        case 'O':
                            dfs(nx,ny);
                            break;
                        case 'X':
                            break;
                        case 'P':
                            count++;
                            dfs(nx,ny);
                            break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];
        int startX = 0;
        int startY = 0;

        for(int i=0;i<n;i++){
            String s = br.readLine();
            for(int j=0;j<m;j++){
                map[i][j] = s.charAt(j);
                if(map[i][j]=='I'){
                    startX = i;
                    startY = j;
                }
            }
        }

        dfs(startX, startY);

        if(count == 0){
            System.out.println("TT");
        }else{
            System.out.println(count);
        }
    }
}