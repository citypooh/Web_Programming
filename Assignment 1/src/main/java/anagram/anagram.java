package anagram;	//anagram 프로그램

import java.util.Arrays;	//배열 메소드를 사용하기 위해 추가
import java.util.Scanner;	//스캐너 메소드를 사용하기 위해 추가

public class anagram {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);	//스캐너 객체 생성
		
		while(true) {	//문자를 입력받고 알파벳 구별해내는 반복문 생성
			System.out.println("첫번째 단어 입력 (그만두려면 quit 입력):");
			String A = scan.nextLine();	//첫번째 단어 입력
			if(A.equals("quit"))	//quit을 입력 받았을 경우
				break;
			System.out.println("두번째 단어 입력 (그만두려면 quit 입력):");
			String B = scan.nextLine();	//두번째 단어 입력
			if(B.equals("quit"))	//quit을 입력 받았을 경우
				break;
			AnagramTest.anagram(A,B);	//밑에서 따로 anagram을 판별하는 메소드를 구현해서 사용
			System.out.println("========================");
			
			//1번째 단어의 알파벳을 구별하는 과정
			char[] alphabet = new char[52];	//알파벳 배열
			int[] count1 = new int[alphabet.length];	//각 알파벳의 사용 횟수 카운트
			for(int i=0;i<alphabet.length;i++) {	//배열 초기화
				if(i<26)	//대,소문자 구별해서 차례대로 저장하는 조건문
					alphabet[i] = (char)(i + 65);	//대문자 저장
				else
					alphabet[i] = (char)(i + 71);	//소문자 저장
			}
			//카운트 진행하는 과정
			for (int i = 0 ; i < A.length() ; i++) {	//단어 길이만큼 반복
			   for (int j = 0 ; j < alphabet.length ; j++) {	//알파벳 길이만큼 반복
				   if (A.charAt(i) == alphabet[j]) {	//입력받은 단어의 i번째 값과 알파벳 배열의 j번째 값이 같을 경우
					   count1[j]++;	//카운트 배열의 j번째 카운트 1증가
					   	break;
				   }
			   }
			}
			//2번째 단어의 알파벳을 구별하는 과정
			int[] count2 = new int[alphabet.length];	//각 알파벳의 사용 횟수 카운트
			for(int i=0;i<alphabet.length;i++) {	//배열 초기화
				if(i<26)	//대,소문자 구별해서 차례대로 저장하는 조건문
					alphabet[i] = (char)(i + 65);	//대문자 저장
				else
					alphabet[i] = (char)(i + 71);	//소문자 저장 
			}
			//카운트 진행하는 과정
			for (int i = 0 ; i < B.length() ; i++) {	//단어 길이만큼 반복
			   for (int j = 0 ; j < alphabet.length ; j++) {	//알파벳 길이만큼 반복
				   if (B.charAt(i) == alphabet[j]) {	//입력받은 단어의 i번째 값과 알파벳 배열의 j번째 값이 같을 경우
					   count2[j]++;	//카운트 배열의 j번째 카운트 1증가
					   	break;
				   }
			   }
			}
			
			System.out.println("2개의 단어의 알파벳이 사용된 횟수를 출력합니다.");
				for (int i = 0 ; i < alphabet.length/2 ; i++) {	//구별한 알파벳 나열하는 과정
					int sum1 = count1[i] + count2[i];	//[i]일때 count1과 count2의 합을 sum1으로 정의
					int sum2 = count1[i+26] + count2[i+26];	//[i+26]일때 count1과 count2의 합을 sum2로 정의
					System.out.print(alphabet[i] + ":" + count1[i] + "+" + count2[i] + " = " + sum1 + "개" + "  , ");
					System.out.println(alphabet[i+26] + ":" + count1[i+26] + "+" + count2[i+26] + " = " + sum2 + "개");
				}
			System.out.println("========================");
		}
		
		AnagramNumber r = new AnagramNumber(AnagramNumber.returnx(),AnagramNumber.returny());
		System.out.println("아나그램 성립 O의 개수:" + AnagramNumber.returnx());
		System.out.println("아나그램 성립 X의 개수:" + AnagramNumber.returny());
		
		scan.close();	//스캐너 객체 종료
	}	
	
}
//anagram인지 판별하는 클래스 구현
class AnagramTest {

	public static void anagram(String a1,String a2) {	//String형 변수 a1,a2
		
			AnagramNumber z = new AnagramNumber(0,0);	//밑에서 anagram인 것과 아닌 것의 개수를 구별하는 클래스 구현해서 사용
			
			//단어의 공백 제거
			a1 = a1.replaceAll("\\p{Z}","");
			a2 = a2.replaceAll("\\p{Z}","");
			
			//두 단어의 길이 체크
			if (a1.length() != a2.length()) {
				System.out.println("결과:두 단어의 길이가 다릅니다.");
				return;
			}
			
			//소문자 변환과 Char형으로 배열 변환하면서 Char형 변수 c1,c2 정의
			char[] c1 = a1.toLowerCase().toCharArray();
			char[] c2 = a2.toLowerCase().toCharArray();
			
			//Arrays.sort() 오름 차순 정렬
			Arrays.sort(c1);
			Arrays.sort(c2);
			
			//String형으로 변환하면서 변수 sc1,sc2 정의
			String sc1 = new String(c1);
			String sc2 = new String(c2);
			
			//단어 내용 비교
			if(sc1.equals(sc2)) {
				System.out.println("결과:아나그램 성립 O");
				z.methodx();	//밑에서 생성한 anagram수를 관리하는 메소드 사용
			} else {
				System.out.println("결과:아나그램 성립 X");
				z.methody();	//밑에서 생성한 anagram수를 관리하는 메소드 사용
			}
	}
	
}
//anagram의 수를 관리하는 클래스 구현
class AnagramNumber {
	
	public static int x;	//anagram의 수
	public static int y;	//anagram이 아닌 것의 수
	//생성자-AnagramTest에서 호출해서 사용
	public AnagramNumber(int x,int y) {
		AnagramNumber.x = x;
		AnagramNumber.y = y;
	}	//anagram의 수를 저장하고 1씩 증가시키는 메소드
	public void methodx() {
		x++;
	}	//anagram이 아닌 것의 수를 저장하고 1씩 증가시키는 메소드
	public void methody() {
		y++;
	}	//저장한 anagram의 수를 리턴하는 메소드
	public static int returnx() {
		return x;
	}	//저장한 anagram이 아닌 것의 수를 리턴하는 메소드
	public static int returny() {
		return y;
	}
}