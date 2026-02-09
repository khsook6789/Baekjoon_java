import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int count = 0;
        int result = 0;

        char[] c = br.readLine().toCharArray();

        for(int i=1;i<m-1;i++){
            if(c[i-1] == 'I' && c[i] == 'O' && c[i+1] == 'I'){
                count++;

                if(count == n){
                    count--;
                    result++;
                }
                i++;
            }
            else{
                count = 0;
            }
        }

        System.out.println(result);
    }
}