import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int n;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count = 0;
    static int[] result;

    static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[]{x, y});

        int size = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            size++;

            for(int i=0;i<4;i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<n){
                    if(graph[nx][ny]==1 && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return size;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        visited = new boolean[n][n];
        result = new int[n * n];

        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<n;j++){
                graph[i][j] = str.charAt(j) -'0';
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(graph[i][j]==1 && !visited[i][j]){
                    result[count] = bfs(i, j);
                    count++;
                }
            }
        }
        Arrays.sort(result);

        System.out.println(count);
        for(int i: result){
            if(i!=0){
                System.out.println(i);
            }
        }
    }
}