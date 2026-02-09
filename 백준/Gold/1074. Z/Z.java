import java.io.*;
import java.util.*;

public class Main {
    static int ans = 0;
    static int n,r,c;

    static void solve(int row, int col, int size){
        if(size == 1){
            System.out.println(ans);
            return;
        }
        int half = size/2;

        if(r < row+half && c < col+half){
            solve(row, col, half);
        }
        else if(r < row+half && c >= col+half){
            ans += half*half;
            solve(row, col+half, half);
        }
        else if(r >= row+half && c < col+half){
            ans += (half*half)*2;
            solve(row+half, col, half);
        }
        else if(r >= row+half && c >= col+half){
            ans += (half*half)*3;
            solve(row+half, col+half, half);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 2^n x 2^n 배열
        r = Integer.parseInt(st.nextToken()); // 행
        c = Integer.parseInt(st.nextToken()); // 열

        int size = (int)Math.pow(2,n);

        solve(0,0,size);
    }
}