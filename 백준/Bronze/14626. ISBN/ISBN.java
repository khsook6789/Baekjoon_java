import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int sum = 0;
        int lost = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != '*') {
                if(i%2==0){
                    sum += (c - '0');
                } else {
                    sum += 3 * (c - '0');
                }
            }else{
                lost = i;
            }
        }

        for (int i = 0; i < 10; i++) {
            if (lost%2==0) {
                if ((sum + i) % 10 == 0) {
                    System.out.println(i);
                    break;
                }
            }else{
                if ((sum + 3 * i) % 10 == 0) {
                    System.out.println(i);
                    break;
                }
            }
        }

        br.close();
    }
}