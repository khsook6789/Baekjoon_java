import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int[] time = new int[n];
        for(int i=1; i<=n; i++) {
            int sum = 0;
            for(int j=0; j<i; j++) {
                sum += arr[j];
            }
            time[i-1] = sum;
        }

        int result = 0;
        for(int i=0; i<n; i++) {
            result += time[i];
        }

        System.out.println(result);
    }
}