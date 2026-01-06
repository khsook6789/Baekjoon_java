import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[][] arr = new String[N][2];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
        }

        Arrays.sort(arr,(s1,s2)->{
            return Integer.parseInt(s1[0])-Integer.parseInt(s2[0]);
        });

        for(String[] s:arr){
            bw.write(s[0]+" "+s[1]+"\n");
        }

        bw.flush();
        bw.close();
    }
}