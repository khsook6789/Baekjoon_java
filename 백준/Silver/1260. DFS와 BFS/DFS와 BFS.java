import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int [][] graph;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int start){
        visited[start] = true;
        sb.append(start).append(" ");

        for(int i=1;i<graph.length;i++){
            if(graph[start][i]==1 && !visited[i]){
                dfs(i);
            }
        }
    }

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);

        while(!q.isEmpty()){
            int current = q.poll();
            sb.append(current).append(" ");

            for(int i=1;i<graph.length;i++){
                if(graph[current][i]==1 && !visited[i]){
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 노드 개수
        int m = Integer.parseInt(st.nextToken()); // 간선 개수
        int v = Integer.parseInt(st.nextToken()); // 시작 노드

        visited = new boolean[n+1];
        graph = new int[n+1][n+1];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        dfs(v);
        sb.append("\n");

        visited = new boolean[n+1];
        bfs(v);

        System.out.println(sb);
    }
}