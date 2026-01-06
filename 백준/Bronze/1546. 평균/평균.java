import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        float[]scores = new float[N];

        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();
        }

        Arrays.sort(scores);
        for (int i = 0; i < N; i++) {
            scores[i] = scores[i]/scores[N-1]*100;
        }

        float sum =0;
        for (int i = 0; i < N;i++){
            sum+=scores[i];
        }
        System.out.println(sum/N);
    }
}