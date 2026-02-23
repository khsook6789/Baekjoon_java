import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[] input;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static void solve(int idx) {
        if(idx == m) {
            for(int i: arr){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = 0;
        for(int i=0;i<n;i++){
            if(visited[i] || prev == input[i]) {
                continue;
            }
            visited[i] = true;
            arr[idx] = input[i];
            prev = input[i];
            solve(idx+1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        input = new int[n];
        arr = new int[m];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n;i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);

        solve(0);

        System.out.print(sb);
    }
}