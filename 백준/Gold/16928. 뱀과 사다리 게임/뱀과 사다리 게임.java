import java.io.*;
import java.net.Inet4Address;
import java.util.*;

public class Main {
    static int n,m;
    static boolean[] visited;
    static int[] board;
    static int[] dice = {1,2,3,4,5,6};

    static void bfs(int x){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,0});
        visited[x] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            if(cur[0] == 100){
                System.out.println(cur[1]);
                return;
            }

            for(int i=0;i<6;i++){
                int move = cur[0]+dice[i];
                if(move<101){
                    if(board[move]!=0){
                        move = board[move];
                    }
                    if(!visited[move]){
                        visited[move] = true;
                        q.offer(new int[]{move,cur[1]+1});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[101];
        visited = new boolean[101];

        for(int i=0;i<n+m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            board[a]=b;
        }

        bfs(1);
    }
}