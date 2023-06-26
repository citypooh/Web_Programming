package chap4;	// 바빌로니안 알고리즘을 이용해 제곱근을 구하는 프로그램

import java.util.Scanner;	//스캐너 메소드를 사용하기 위해 추가

public class Ex1 {
	
	public static double babylonianSqrt(double x) {	//바빌로니안 메소드 구현
		double guess = x;	//원하는 값을 추측 값으로 설정
		while(true) {	//while문으로 제곱근을 구할때까지 아래 과정을 반복
			double avg = ((x/guess)+guess)/2;	//원하는 수를 추측값으로 나눈 값과 추측값과의 평균
			if(guess == avg) {	//추측값과 위에서 구한 평균이 같을 경우
				return guess;	//제곱근을 구했으니 리턴
			}
			guess = avg;	//위에서 구한 평균 값을 추측값에 대입해 새로운 추측값 생성
		}
	}
	
	public static void main(String[] args) { 
		Scanner scan = new Scanner(System.in); //스캐너 객체 생성
		System.out.print("원하는 값 입력:");
		double d = scan.nextDouble();	//원하는 수를 입력
		System.out.println("==========================");
		System.out.print(d + "의 제곱근:");	
		System.out.printf("%.8f",babylonianSqrt(d));	//소수점 이하 8자리 까지 구하는 코드
	
		scan.close();	//스캐너 객체 종료
		  
	} 
}
