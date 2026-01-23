import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int sum = 0;
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);

        boolean flag = false;
        int mode_max = 0;
        int mode = 4001;

        for(int i=0;i<n;i++){
            int jump = 0;
            int count = 1;
            int value = arr[i];

            for(int j=i+1;j<n;j++){
                if(arr[j] != value){
                    break;
                }
                count++;
                jump++;
            }
            if(count > mode_max){
                mode_max = count;
                mode = value;
                flag = true;
            } else if(count == mode_max && flag){
                mode = value;
                flag = false;
            }
            i += jump;
        }

        System.out.println((int)Math.round((double)sum/n));
        System.out.println(arr[n/2]);
        System.out.println(mode);
        System.out.println(arr[n-1] - arr[0]);
    }
}