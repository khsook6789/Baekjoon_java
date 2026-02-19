import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int cur, int idx){
        if (idx == m) {
            for (int i : arr) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=cur;i<=n;i++){
            arr[idx]=i;
            dfs(i,idx+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        dfs(1,0);
        System.out.println(sb);
    }
}