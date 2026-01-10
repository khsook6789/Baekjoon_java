import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][3];
        int[] rate = new int[n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<n;i++){
            int count = 1;
            for(int j=0;j<n;j++){
                if(arr[i][0]<arr[j][0]&&arr[i][1]<arr[j][1]){
                    count++;
                }
            }
            rate[i] = count;
        }

        for(int i=0;i<n;i++){
            System.out.print(rate[i]+" ");
        }

        br.close();
    }
}