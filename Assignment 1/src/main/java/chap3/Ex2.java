package chap3;	//몸무게와 키를 읽어서 BMI와 비만도를 판정하는 프로그램
	
import java.util.Scanner;	//스캐너 메소드를 사용하기 위해 추가
	
public class Ex2 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);	//스캐너 객체 생성
		
		double weight,height;	//몸무게,키
		double BMI;	//BMI 측정도
		
		System.out.println("BMI와 비만도를 측정하는 프로그램입니다. ");
		
		System.out.println("몸무게(kg)와 키(m)를 입력하시오 : ");
		weight = scan.nextDouble();	//몸무게 입력
		height = scan.nextDouble();	//키 입력
		BMI = weight/(height*height);	//BMI를 측정하는 식
		
		if(BMI < 15.0) {	//BMI 측정도가 15.0 미만일때
			System.out.println("==========================");
			System.out.println("병적인 저체중");
		}
		if(BMI >= 15.0 && BMI < 18.5) {	//BMI 측정도가 15.0 이상 18.5 미만일때
			System.out.println("==========================");
			System.out.println("저체중");
		}
		if(BMI >= 18.5 && BMI < 23.0) {	//BMI 측정도가 18.5 이상 23.0 미만일때
			System.out.println("==========================");
			System.out.println("정상");
		}
		if(BMI >= 23.0 && BMI <= 27.5) {	//BMI 측정도가 23.0 이상 27.5 이하일때
			System.out.println("==========================");
			System.out.println("과체중");
		}
		if(BMI > 27.5 && BMI <= 40.0) {	//BMI 측정도가 27.5 초과 40.0 이하일때			
			System.out.println("==========================");
			System.out.println("비만");
		}
		if(BMI > 40.0) {	//BMI 측정도가 40.0 초과일때
			System.out.println("==========================");
			System.out.println("병적인 비만");
		}
		
		scan.close();	//스캐너 객체 종료
	}

}
