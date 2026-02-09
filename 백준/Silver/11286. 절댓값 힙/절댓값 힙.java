import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{
            if(Math.abs(o1) == Math.abs(o2)){
                return o1-o2;
            }else{
                return Math.abs(o1)-Math.abs(o2);
            }
        });

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(pq.isEmpty()){
                    sb.append(num).append("\n");
                }else{
                    sb.append(pq.poll()).append("\n");
                }
            }else{
                pq.offer(num);
            }
        }

        System.out.println(sb);
    }
}