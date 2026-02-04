import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==j){
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = 10000;
                }
            }
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(graph[i][j] > graph[i][k] + graph[k][j]){
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        int min = 10000;
        int result = 0;

        for(int i=1;i<=n;i++){
            int sum =0;
            for(int j=1;j<=n;j++){
                sum += graph[i][j];
            }

            if(min>sum){
                min = sum;
                result = i;
            }
        }

        System.out.println(result);
    }
}