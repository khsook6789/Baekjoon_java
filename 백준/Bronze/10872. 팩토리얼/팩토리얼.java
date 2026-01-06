import java.util.Scanner;
public class Main {
	
	static int factorial(int N) {
		int result=1;
		for(int i=1;i<N+1;i++) {
			result*=i;
		}
		return result;
	}

	public static void main(String[] args) {
		int N;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		System.out.println(factorial(N));
	}

}