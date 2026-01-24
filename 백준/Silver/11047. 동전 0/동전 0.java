import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[]arr = new int[n];

        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int idx = -1;
        for(int i=0;i<n;i++) {
            if(arr[i]>k){break;}
            idx++;
        }

        int count = 0;
        while(k!=0){
            count+=k/arr[idx];
            k=k%arr[idx];
            idx--;
        }
        System.out.println(count);
    }
}