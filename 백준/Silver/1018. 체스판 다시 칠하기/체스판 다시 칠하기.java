import java.io.*;
import java.util.*;

public class Main {
    public static boolean[][]arr;
    public static int min = 64;

    public static void find(int x,int y){
        int count = 0;
        int end_x = x + 8;
        int end_y = y + 8;

        boolean tf = arr[x][y];

        for(int i=x;i<end_x;i++){
            for(int j=y;j<end_y;j++){
                // 올바른 색이 아닐경우 count ++
                if(arr[i][j] != tf){
                    count++;
                }
                tf = !tf;
            }
            tf = !tf;
            // 칸 이동시마다 색 변경 true -> false / false -> true
        }
        // W로 시작하는 경우와 B로 시작하는 경우 중 더 작은 값을 선택
        count = Math.min(count, 64 - count);
        min = Math.min(min, count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new boolean[n][m];

        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<m;j++){
                if(str.charAt(j)=='W'){
                    arr[i][j] = true;
                }else{
                    arr[i][j] = false;
                }
            }
        }

        int n_row = n - 7;
        int m_col = m - 7;
        for(int i=0;i<n_row;i++){
            for(int j=0;j<m_col;j++){
                find(i,j);
            }
        }
        System.out.println(min);
    }
}