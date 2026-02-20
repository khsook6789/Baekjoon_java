import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[] input;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int idx){
        if(idx == m){
            for(int i : arr){
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i] = true;
                arr[idx] = input[i];
                dfs(idx+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        // n개의 자연수중에서 m개 고른 수열 ex)3개의 자연수 중 1개 고름

        input = new int[n];
        arr = new int[m];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);

        dfs(0);
        
        System.out.println(sb);
    }
}