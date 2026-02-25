import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[] input;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    static void solve(int cur,int idx) {
        if(idx == m) {
            for(int i: arr){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = 0;
        for(int i=cur;i<n;i++){
            if(prev == input[i]){
                continue;
            }
            prev = input[i];
            arr[idx]=input[i];
            solve(i,idx+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        input = new int[n];
        arr = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n;i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);

        solve(0,0);

        System.out.print(sb);
    }
}