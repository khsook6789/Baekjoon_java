import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] Number = br.readLine().split("");
            String[] reversedNumber = new String[Number.length];

            if(Number[0].equals("0")) {
                break;
            }

            for (int i = 0; i < Number.length; i++) {
                reversedNumber[i] = Number[Number.length-i-1];
            }

            if (Arrays.equals(reversedNumber, Number)) {
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }
}