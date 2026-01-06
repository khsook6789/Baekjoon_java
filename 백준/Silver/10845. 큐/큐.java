import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[] queue;
    public static int front = 0;
    public static int rear = 0;

    public static void push(int item) {
        queue[rear] = item;
        rear++;
    }

    public static int pop() {
        if (rear - front == 0) {
            return -1;
        }else{
            return queue[front++];
        }
    }

    public static int size() {
        return rear-front;
    }

    public static int empty() {
        if(rear == front){
            return 1;
        }else{
            return 0;
        }
    }

    public static int front() {
        if(rear - front == 0){
            return -1;
        }else{
            return queue[front];
        }
    }

    public static int back(){
        if(rear - front == 0){
            return -1;
        }else{
            return queue[rear-1];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        queue = new int[10001];

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    bw.write(pop() + "\n");
                    break;
                case "size":
                    bw.write(size() + "\n");
                    break;
                case "empty":
                    bw.write(empty() + "\n");
                    break;
                case "front":
                    bw.write(front() + "\n");
                    break;
                case "back":
                    bw.write(back()+"\n");
                    break;
            }
        }

        bw.flush();
        bw.close();
    }
}