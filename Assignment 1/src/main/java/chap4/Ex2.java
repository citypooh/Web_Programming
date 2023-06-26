package chap4;	// 빠른 거듭제곱 함수를 만드는 프로그램
	
import java.util.Scanner;	//스캐너 메소드를 사용하기 위해 추가

public class Ex2 {
	
	public static int fastPower(int x,int n) {	//빠른 거듭제곱 메소드 구현
		if (n == 0) {	//x의 0승일 경우
	        return 1;
	    }
	    int y = fastPower(x, n / 2);	//x의 n/2승을 빠른 거듭제곱 메소드를 통해 구현시킨 코드
	    int z = y * y;	//x의 n/2승을 거듭제곱한 코드
	 
	    if (n % 2 == 0) {	//n이 짝수일 경우
	        return z;
	    } else {	//n이 짝수가 아닐 경우
	        return x * z;
	    }
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);	//스캐너 객체 생성
		System.out.println("거듭제곱 할 숫자 입력:");
		int x = scan.nextInt();	//x의 값 입력
		System.out.println("거듭제곱 할 횟수 입력:");
		int n = scan.nextInt();	//n의 값 입력
		System.out.println("==========================");
		System.out.println(x + "의 " + n + "제곱 = " + fastPower(x,n));	//빠른 거듭제곱 메소드를 통해 구한 x의 n승을 출력
		
		scan.close();	//스캐너 객체 종료
	}

}
