import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int rear = 0;
        int front = n;
        int[] queue = new int[n*2+1];

        for (int i = 1; i <= n; i++) {
            queue[i-1] = i;
        }

        while(front-rear>1) { //while문 조건 수정해서 최적화
            rear++;
            queue[front++] = queue[rear++];
        }
        System.out.println(queue[rear]);
    }
}