import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    //시간 3초, 메모리 512MB
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // StringBuilder 사용 : sb.append(Arr[i])

        int N = Integer.parseInt(br.readLine());
        int[] Arr = new int[N];

        for (int i=0;i<N;i++){
            Arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(Arr);

        for (int i=0;i<N;i++){
            sb.append(Arr[i]).append('\n');
        }
        
        System.out.println(sb);
    }
}