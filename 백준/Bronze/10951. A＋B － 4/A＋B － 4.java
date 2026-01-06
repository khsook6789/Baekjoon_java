import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a=sc.nextInt();
            int b=sc.nextInt();

            System.out.println(a+b);
        }
    }
}