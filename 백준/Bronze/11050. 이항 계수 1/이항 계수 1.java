import java.io.IOException;
import java.util.Scanner;

public class Main {
    //이항계수 -> nCk (조합) n!/(k!(n-k)!)
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int numerator = 1;
        int denominator = 1;
        int denominator1 = 1;

        for(int i=2;i<=n;i++){
            numerator = numerator*i;
        }

        for(int i=2;i<=k;i++){
            denominator = denominator*i;
        }

        for(int i=2;i<=n-k;i++){
            denominator1 = denominator1*i;
        }

        int result = numerator/(denominator*denominator1);

        System.out.println(result);
    }
}