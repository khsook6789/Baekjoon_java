import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String []input = br.readLine().split(" ");
            long a = Integer.parseInt(input[0]);
            long b = Integer.parseInt(input[1]);
            long c = Integer.parseInt(input[2]);
            long [] Arr = new long[]{a, b, c};
            Arrays.sort(Arr);

            if (a == 0 && b == 0 && c == 0)
                break;
            else if(Arr[2]*Arr[2]==Arr[1]*Arr[1]+Arr[0]*Arr[0])
                System.out.println("right");
            else
                System.out.println("wrong");
        }

        br.close();

    }
}