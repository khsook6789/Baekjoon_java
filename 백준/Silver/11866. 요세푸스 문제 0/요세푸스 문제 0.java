import java.io.*;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        int n = sc.nextInt();
        int k = sc.nextInt();


        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        while(q.size()>1) {
            for(int i =0; i < k-1; i++){
                int x = q.remove();
                q.add(x);
            }
            sb.append(q.remove()).append(", ");
        }
        sb.append(q.remove()).append('>');
        System.out.println(sb);
    }
}