import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[][] graph;
    static int count = 0;

    public static void dfs(int n){
        visited[n] = true;
        count++;

        for(int i=1;i<graph.length;i++){
            if(graph[n][i]==1&& !visited[i]){
                dfs(i);
            }
        }
    }

    public static void bfs(int n){
        Queue<Integer> q = new LinkedList<>();
        visited[n] = true;
        q.offer(n);

        while(!q.isEmpty()){
            int current = q.poll();

            for(int i=1;i<graph.length;i++){
                if(graph[current][i]==1 && !visited[i]){
                    q.offer(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); //컴퓨터 수
        int m = Integer.parseInt(br.readLine()); // 연결 쌍 수

        visited = new boolean[n + 1];
        graph = new int[n + 1][n + 1];

        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

//        dfs(1);
//        System.out.println(count - 1);

        bfs(1);
        System.out.println(count);
    }
}