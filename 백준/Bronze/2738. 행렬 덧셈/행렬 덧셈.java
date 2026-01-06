import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input[] = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int a [][] = new int[n][m];
        int b [][] = new int[n][m];
        int sum[][] = new int[n][m];

        for(int i =0;i<n;i++){
            String aInput[]=br.readLine().split(" ");
            for(int j =0;j<m;j++){
                a[i][j] = Integer.parseInt(aInput[j]);
            }
        }

        for(int i =0;i<n;i++){
            String bInput[]=br.readLine().split(" ");
            for(int j =0;j<m;j++){
                b[i][j] = Integer.parseInt(bInput[j]);
            }
        }

        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                sum[i][j] =  a[i][j] + b[i][j];
            }
        }

        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                bw.write(sum[i][j]+" ");
            }
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }
}