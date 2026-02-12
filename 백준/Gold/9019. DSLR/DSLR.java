import java.io.*;
import java.util.*;

public class Main {
    static String[] cmd;
    static boolean[] visited;
    static int[] parent;
    static StringBuilder sb;

    static void bfs(int start, int end){
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);

        while(!q.isEmpty()){
            int cur = q.poll();

            if(cur == end){
                int now = end;

                while(now!=start){
                    sb.append(cmd[now]);
                    now = parent[now];
                }
                sb.reverse();

                break;
            }

            int d = (cur*2) % 10000;
            int s = cur == 0? 9999: cur-1;
            int l = (cur%1000)*10 + cur/1000;
            int r = (cur%10)*1000 + cur/10;

            if(!visited[d]){
                cmd[d] = "D";
                parent[d] = cur;
                q.offer(d);
                visited[d] = true;
            }
            if(!visited[s]){
                cmd[s] = "S";
                parent[s] = cur;
                q.offer(s);
                visited[s] = true;
            }
            if(!visited[l]){
                cmd[l] = "L";
                parent[l] = cur;
                q.offer(l);
                visited[l] = true;
            }
            if(!visited[r]){
                cmd[r] = "R";
                parent[r] = cur;
                q.offer(r);
                visited[r] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            cmd = new String[10000];
            visited = new boolean[10000];
            parent = new int[10000];

            cmd[x] = "";

            bfs(x,y);

            System.out.println(sb);
        }
    }
}