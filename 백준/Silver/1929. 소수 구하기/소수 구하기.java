import java.io.*;
import java.util.*;

public class Main {
    public static void prime(int n){
        if(n<2){
            return;
        }
        if(n==2){
            System.out.println(n);
            return;
        }
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return;
            }
        }
        System.out.println(n);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        for(int i=m;i<=n;i++){
            prime(i);
        }
    }
}