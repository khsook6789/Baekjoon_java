import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int count = 1;
        int currentNum=666;

        while(count!=n){
            currentNum++;
            if(String.valueOf(currentNum).contains("666")){
                count++;
            }
        }

        System.out.println(currentNum);

        bw.flush();
        bw.close();
        br.close();
    }
}