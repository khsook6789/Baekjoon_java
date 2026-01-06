import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[][] apt = new int[15][15];

        for (int i = 1; i < 15; i++) { //0층 1~n호 = i
            apt[0][i]=i;
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                if(j==1)
                    apt[i][1]=1;   //k층 1호 = 1
                else
                    apt[i][j]=apt[i][j-1]+apt[i-1][j];
            }
        }

        while(true){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(apt[k][n]);
            T--;
            if(T==0)
                break;
        }
    }
}