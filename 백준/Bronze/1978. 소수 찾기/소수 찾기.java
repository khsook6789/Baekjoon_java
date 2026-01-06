import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] pnum = new int[N];
        int count =0;
        int p_count = 0;

        for (int i =0;i<N;i++){
            pnum[i] = sc.nextInt();
        }

        for(int i:pnum){
            for(int j=1;j<=i;j++){
                if(i%j==0)
                    count++;
            }
            if(count==2){
                p_count++;
                count=0;
            }else{count=0;}
        }
        System.out.println(p_count);
    }
}