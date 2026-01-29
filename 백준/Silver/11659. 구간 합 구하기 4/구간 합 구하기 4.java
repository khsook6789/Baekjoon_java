import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 수의 개수
        int m = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] prefixSum = new int[n+1];
        prefixSum[0] = 0;
        for(int i=1;i<=n;i++){
            prefixSum[i] = prefixSum[i-1] + arr[i-1];
        }

        for(int t=0;t<m;t++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            sb.append(prefixSum[j] - prefixSum[i-1]).append('\n');
        }

        System.out.print(sb);
    }
}