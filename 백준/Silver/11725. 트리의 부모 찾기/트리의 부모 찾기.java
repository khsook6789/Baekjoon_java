import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] parent;

    public static void dfs(int start){
        visited[start] = true;

        for(int i:graph[start]){
            if(!visited[i]){
                parent[i] = start;
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        parent = new int[n+1];

        for(int i=1;i<=n;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<n-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for(int i=2;i<parent.length;i++){
            sb.append(parent[i]).append("\n");
        }

        System.out.print(sb);
    }
}