import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static int oneCount = 0;
    static int zeroCount = 0;

    public static void solve(int row, int col, int n){

        if(check(row,col,n)){
            if(board[row][col] == 1){
                oneCount++;
            }else{
                zeroCount++;
            }
        }else{
            int size = n/2;
            solve(row,col,size);
            solve(row+size,col,size);
            solve(row,col+size,size);
            solve(row+size,col+size,size);
        }
    }

    public static boolean check(int row, int col, int n){
        int color = board[row][col];

        for(int i=row;i<row+n;i++){
            for(int j=col;j<col+n;j++){
                if(board[i][j]!=color){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0,0,n);

        System.out.println(zeroCount);
        System.out.println(oneCount);
    }
}