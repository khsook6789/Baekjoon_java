import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println(recur(n,0));
    }

    static int recur(int n, int count){
        if(n<2){
            return count;
        }

        return Math.min(recur(n/2,count+n%2+1),recur(n/3,count+n%3+1));
    }
}