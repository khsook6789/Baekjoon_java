import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int cut = (int)Math.round(n*0.15);

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int sum =0;
        for(int i=cut;i<n-cut;i++){
            sum+=arr[i];
        }
        // 분모 = n - 2*cut
        double avg = sum/(double)(n - 2 * cut);
        System.out.println((int)Math.round(avg));

        br.close();
    }
}