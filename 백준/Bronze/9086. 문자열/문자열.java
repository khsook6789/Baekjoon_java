import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            int last =  str.length() - 1;
//            System.out.println(String.format("%c","%c",str.charAt(0),str.charAt(last))); //x
//            System.out.println(String.format("%c", str.charAt(0))+String.format("%c", str.charAt(last)));
//            System.out.println(String.format("%c%c", str.charAt(0),str.charAt(last)));
            System.out.println(""+str.charAt(0)+str.charAt(last));

        }
    }
}