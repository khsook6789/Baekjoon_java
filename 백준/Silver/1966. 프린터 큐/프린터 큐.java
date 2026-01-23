import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

       for (int i=0;i<T;i++) {
           StringTokenizer st = new StringTokenizer(br.readLine());
           int N = Integer.parseInt(st.nextToken());
           int M = Integer.parseInt(st.nextToken());

           LinkedList<int[]> queue = new LinkedList<>();

           st = new StringTokenizer(br.readLine());
           for(int j=0;j<N;j++){
               //{초기 위치, 중요도}
               queue.offer(new int[]{j, Integer.parseInt(st.nextToken())});
           }

           int count = 0;

           while(!queue.isEmpty()){
               int[] front = queue.poll();
               boolean isMax = true;

               // queue 순회
               for(int j=0;j< queue.size();j++){
                   //중요도 비교
                   if(front[1] < queue.get(j)[1]){
                       //처음 뽑은 원소보다 중요도가 큰 j번째 원소 존재 시
                       //front + j 뒤의 원소들 뒤로 보냄
                       queue.offer(front);
                       for(int k=0;k<queue.size();k++){
                            queue.offer(queue.poll());
                       }
                       isMax = false;
                       break;
                   }
               }
               // front가 가장 큰 중요도가 아니므로 다음 반복문 실행
               if(!isMax){
                   continue;
               }
                
               // front가 가장 큰 중요도일때 출력 횟수 증가
               count++;
               if(front[0]==M){
                   // front가 가장 큰 중요도이고, 찾는 문서이면 종료
                   break;
               }
           }
           // count 저장하고 다음 테스트케이스 실행
           sb.append(count).append('\n');
       }
       System.out.print(sb);
    }
}