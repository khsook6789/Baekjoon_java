import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] size = new int[6];
        for(int i=0;i<6;i++)
            size[i] = sc.nextInt();

        int T = sc.nextInt();
        int P = sc.nextInt();

        int sum = 0;
        for(int i:size){
            int quantity = i%T ==0?i/T:i/T+1;
            sum+=quantity;
        }


        System.out.println(sum);
        System.out.println(n/P+" "+n%P);
    }
}