import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        //dp[5] = dp[0] + dp[4] = 2;
        //dp[6] = dp[1] + dp[5] = 3
        //dp[7] = dp[2] + dp[6] = 4
        //dp[n] = dp[n-5] + dp[n-1]

        for(int i=5;i<=100;i++){
            dp[i] = dp[i-5] + dp[i-1];
        }

        for(int t=0;t<T;t++){
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }
        System.out.print(sb);
    }
}