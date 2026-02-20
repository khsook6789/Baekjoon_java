import java.io.*;
import java.util.*;

public class Main {
    static int[] dp;
    static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp = new int[n];
        input = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;

        for(int i=0;i<n;i++){
            dp[i] = 1;

            for(int j=0;j<n;j++){
                if(input[j]<input[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }

            max = Math.max(max,dp[i]);
        }

        System.out.println(max);
    }
}