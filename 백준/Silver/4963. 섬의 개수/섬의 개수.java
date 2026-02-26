import java.io.*;
import java.util.*;

public class Main {
    static int w,h;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1,  0,  1, 1,-1, 1,-1, 0};

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i=0;i<8;i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx>=0 && nx<w && ny>=0 && ny<h){
                    if(board[nx][ny]==1 && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) break;

            board = new int[w][h];
            visited = new boolean[w][h];
            int count = 0;

            for(int j=0;j<h;j++){
                st = new StringTokenizer(br.readLine());
                for(int i=0;i<w;i++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0;i<w;i++){
                for(int j=0;j<h;j++){
                    if(board[i][j] == 1 && !visited[i][j]){
                        count++;
                        bfs(i, j);
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}