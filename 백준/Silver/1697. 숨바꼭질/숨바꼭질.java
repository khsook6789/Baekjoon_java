import java.io.*;
import java.util.*;

public class Main {
    static int[] graph;
    static int n, k;

    public static int bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        graph[start] = 1;

        while(!q.isEmpty()){
            int cur = q.poll();

            if(cur == k){
                return graph[cur]-1;
            }
            if(cur-1>=0 && graph[cur-1]==0){
                q.offer(cur-1);
                graph[cur-1] = graph[cur]+1;
            }
            if(cur+1<graph.length && graph[cur+1]==0){
                q.offer(cur+1);
                graph[cur+1] = graph[cur]+1;
            }
            if(cur*2<graph.length && graph[cur*2]==0){
                q.offer(cur*2);
                graph[cur*2] = graph[cur]+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 초기 위치
        k = Integer.parseInt(st.nextToken()); // 목표 위치

        graph = new int[100001];

        int result = bfs(n);
        System.out.println(result);
    }
}