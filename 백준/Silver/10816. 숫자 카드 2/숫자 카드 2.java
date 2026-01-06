import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
//10816
public class Main {
    public static int[] Arr1;

    public static int lower_bound(int key){
        int low = 0;
        int high = Arr1.length;

        while(low<high){
            int mid = (low+high)/2;
            /*
             * key값이 mid보다 작거나 같을 경우 왼쪽으로 탐색
             */
            if(key<=Arr1[mid]){
                high = mid;
            }else{
                low = mid+1;
            }
        }

        return low;
    }

    public static int upper_bound(int key){
        int low = 0;
        int high = Arr1.length;

        while(low<high){
            int mid = (low+high)/2;

            if(key<Arr1[mid]){
                high = mid;
            }else{
                low = mid+1;
            }
        }

        return low;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        Arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            Arr1[i] = sc.nextInt();
        }
        //6 3 2 10 10 10 -10 -10 7 3
        Arrays.sort(Arr1);
        //-10 -10 2 3 3 6 7 10 10 10

        int m = sc.nextInt();
        for(int i = 0; i<m;i++){
            int key = sc.nextInt();

            sb.append(upper_bound(key) - lower_bound(key)).append(' ');
        }
        System.out.println(sb);
    }
}