import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String n1 = br.readLine();
        int n = Integer.parseInt(n1);

        int [] array = new int[n];

        String [] inputArray = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            array[i] = Integer.parseInt(inputArray[i]);
        }

        String v1 = br.readLine();
        int v = Integer.parseInt(v1);

        int count = 0;
        for(int i: array){
            if(i==v)
                count++;
        }

        bw.write(count+" ");

        bw.flush();
        br.close();
        bw.close();
    }
}