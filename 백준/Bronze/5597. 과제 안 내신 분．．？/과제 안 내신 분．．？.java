import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int [] student = new int[30];
        for(int i = 0; i < student.length; i++){
            student[i] = i+1;
        }

        int [] input = new int[28];
        for (int i = 0; i < input.length; i++){
            input[i] = Integer.parseInt(br.readLine());
        }

        for(int i:student){
            boolean submitted = false;
            for(int j:input){
                if(i==j)
                    submitted=true;
            }
            if(!submitted){
                bw.write(i+"\n");
            }
        }



        bw.flush();
        br.close();
        bw.close();
    }
}