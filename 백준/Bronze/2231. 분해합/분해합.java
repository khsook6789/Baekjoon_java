import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;
        //ex)216일때 생성자 1부터 216-1까지 순회
        for(int i = 0; i < N; i++) {
            int sum = 0;
            int num = i;

            // i + 각 자릿수 더하기
            while(num!=0){
                sum += num%10;
                num /= 10;
            }
            // i = 생성자이면 break
            if(sum+i == N){
                result=i;
                break;
            }
        }
        System.out.println(result);
    }
}