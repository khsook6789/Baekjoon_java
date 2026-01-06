import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static int gcd(int a, int b){
        if(b==0)
            return a;
        return gcd(b,a%b);
    }

    public static int lcm(int a, int b){
        return a*b/gcd(a,b);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        if(B>A){
            int sortAB = A;
            A=B;
            B=sortAB;
        }

        int gcd = gcd(A,B); //최대공약수
        int lcm = lcm(A,B); //최소공배수

        System.out.println(gcd);
        System.out.println(lcm);
    }
}