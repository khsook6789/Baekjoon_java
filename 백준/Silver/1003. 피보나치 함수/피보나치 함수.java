import java.io.*;
import java.util.*;

public class Main {
    static int zero;
    static int one;
    static int zero_one;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            int n = Integer.parseInt(br.readLine());
            fibonacci(n);
            sb.append(zero).append(' ').append(one).append('\n');
        }
        System.out.print(sb);
    }

    public static void fibonacci(int n){
        zero = 1;
        one = 0;
        zero_one = 1;

        for(int i=0;i<n;i++){
            zero = one;
            one = zero_one;
            zero_one = zero+one;
        }
    }
}