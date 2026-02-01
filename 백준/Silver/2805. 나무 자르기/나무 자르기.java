import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 나무의 수
        int m = Integer.parseInt(st.nextToken()); // 최소로 필요한 나무의 길이

        int max = 0;
        int[] trees = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if(trees[i] > max) {
                max = trees[i];
            }
        }

        int min = 0;
        int mid;

        while(min<max){
            mid = (min+max)/2;

            long sum = 0;

            for(int i=0;i<n;i++){
                if(trees[i]>mid){
                    sum+=trees[i]-mid;
                }
            }

            if(sum < m){
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min-1);
    }
}