import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 벌집 구조, 방 개수 1,6,12,18,24, 한 층마다 6개씩 증가
        int count = 1;
        int range = 2;

        if(N==1){
            System.out.println(count);
        }
        else{
            while (range <= N) {
                range += count*6;
                count++;
            }
            System.out.println(count);
        }
    }
}