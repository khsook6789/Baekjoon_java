import java.io.*;
import java.util.*;

public class Main {
    /*  가능한 행동
     *  1. 좌표 (i, j)의 가장 위에 있는 블록을 제거하여 인벤토리에 넣는다.
     *  2. 인벤토리에서 블록을 꺼내 좌표 (i, j)의 가장 위에 있는 블록 위에 놓는다.
     *  1번 작업은 2초가 걸리며, 2번 작업은 1초가 걸린다.
     *  답이 여러 개 있다면 그중에서 땅의 높이가 가장 높은 것을 출력
     */
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 세로
        int m = Integer.parseInt(st.nextToken()); // 가로
        int b = Integer.parseInt(st.nextToken()); // 가지고 있는 블록 수

        map = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int height = 0;

        for(int h = min; h <=max; h++){
            int time = 0;
            int blocks = b;

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(map[i][j]>h){
                        time += 2*(map[i][j]-h);
                        blocks += (map[i][j]-h);
                    }else if(map[i][j]<h){
                        time += h-map[i][j];
                        blocks -= (h-map[i][j]);
                    }
                }
            }
            if(blocks >=0){
                if(minTime >= time){
                    minTime = time;
                    height = h;
                }
            }
        }
        System.out.println(minTime+" "+height);
    }
}