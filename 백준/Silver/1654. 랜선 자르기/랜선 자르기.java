import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선 개수
        int n = Integer.parseInt(st.nextToken()); // 만들어야 하는 랜선 개수

        long max = 0; // 랜선의 최대 길이

        int[] cables = new int[k];
        for(int i=0;i<k;i++){
            cables[i] = Integer.parseInt(br.readLine());
            if(cables[i] > max){
                max = cables[i];
            }
        }

        max++;
        long min = 0;
        long mid;
        
        // upper bound
        while(min<max){
            mid = (max+min)/2;

            long count = 0;

            for(int i=0;i<k;i++){
                count += cables[i]/mid;
            }

            /*
             *  mid길이로 잘랐을 때의 개수가 만들고자 하는 랜선의 개수보다 작다면
             *  자르고자 하는 길이를 줄이기 위해 최대 길이를 줄인다.
             * 
             *  그 외에는 자르고자 하는 길이를 늘려야 하므로 최소 길이를 늘린다.
             */
            if(count<n){
                max = mid;
            }else{
                min = mid + 1;
            }
        }

        System.out.println(min-1);
    }
}