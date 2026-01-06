import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String []str = br.readLine().split("");
        int i = Integer.parseInt(br.readLine());

        System.out.println(str[i-1]);

        bw.flush();
        br.close();
        bw.close();
    }
}