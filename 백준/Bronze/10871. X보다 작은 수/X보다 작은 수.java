import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int x = Integer.parseInt(input[1]);

        int [] array = new int[n];

        String [] inputArray = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            array[i] = Integer.parseInt(inputArray[i]);
        }

        for(int i: array){
            if(i < x)
                bw.write(i+" ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}