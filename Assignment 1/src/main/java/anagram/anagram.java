package anagram;	//anagram ���α׷�

import java.util.Arrays;	//�迭 �޼ҵ带 ����ϱ� ���� �߰�
import java.util.Scanner;	//��ĳ�� �޼ҵ带 ����ϱ� ���� �߰�

public class anagram {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);	//��ĳ�� ��ü ����
		
		while(true) {	//���ڸ� �Է¹ް� ���ĺ� �����س��� �ݺ��� ����
			System.out.println("ù��° �ܾ� �Է� (�׸��η��� quit �Է�):");
			String A = scan.nextLine();	//ù��° �ܾ� �Է�
			if(A.equals("quit"))	//quit�� �Է� �޾��� ���
				break;
			System.out.println("�ι�° �ܾ� �Է� (�׸��η��� quit �Է�):");
			String B = scan.nextLine();	//�ι�° �ܾ� �Է�
			if(B.equals("quit"))	//quit�� �Է� �޾��� ���
				break;
			AnagramTest.anagram(A,B);	//�ؿ��� ���� anagram�� �Ǻ��ϴ� �޼ҵ带 �����ؼ� ���
			System.out.println("========================");
			
			//1��° �ܾ��� ���ĺ��� �����ϴ� ����
			char[] alphabet = new char[52];	//���ĺ� �迭
			int[] count1 = new int[alphabet.length];	//�� ���ĺ��� ��� Ƚ�� ī��Ʈ
			for(int i=0;i<alphabet.length;i++) {	//�迭 �ʱ�ȭ
				if(i<26)	//��,�ҹ��� �����ؼ� ���ʴ�� �����ϴ� ���ǹ�
					alphabet[i] = (char)(i + 65);	//�빮�� ����
				else
					alphabet[i] = (char)(i + 71);	//�ҹ��� ����
			}
			//ī��Ʈ �����ϴ� ����
			for (int i = 0 ; i < A.length() ; i++) {	//�ܾ� ���̸�ŭ �ݺ�
			   for (int j = 0 ; j < alphabet.length ; j++) {	//���ĺ� ���̸�ŭ �ݺ�
				   if (A.charAt(i) == alphabet[j]) {	//�Է¹��� �ܾ��� i��° ���� ���ĺ� �迭�� j��° ���� ���� ���
					   count1[j]++;	//ī��Ʈ �迭�� j��° ī��Ʈ 1����
					   	break;
				   }
			   }
			}
			//2��° �ܾ��� ���ĺ��� �����ϴ� ����
			int[] count2 = new int[alphabet.length];	//�� ���ĺ��� ��� Ƚ�� ī��Ʈ
			for(int i=0;i<alphabet.length;i++) {	//�迭 �ʱ�ȭ
				if(i<26)	//��,�ҹ��� �����ؼ� ���ʴ�� �����ϴ� ���ǹ�
					alphabet[i] = (char)(i + 65);	//�빮�� ����
				else
					alphabet[i] = (char)(i + 71);	//�ҹ��� ���� 
			}
			//ī��Ʈ �����ϴ� ����
			for (int i = 0 ; i < B.length() ; i++) {	//�ܾ� ���̸�ŭ �ݺ�
			   for (int j = 0 ; j < alphabet.length ; j++) {	//���ĺ� ���̸�ŭ �ݺ�
				   if (B.charAt(i) == alphabet[j]) {	//�Է¹��� �ܾ��� i��° ���� ���ĺ� �迭�� j��° ���� ���� ���
					   count2[j]++;	//ī��Ʈ �迭�� j��° ī��Ʈ 1����
					   	break;
				   }
			   }
			}
			
			System.out.println("2���� �ܾ��� ���ĺ��� ���� Ƚ���� ����մϴ�.");
				for (int i = 0 ; i < alphabet.length/2 ; i++) {	//������ ���ĺ� �����ϴ� ����
					int sum1 = count1[i] + count2[i];	//[i]�϶� count1�� count2�� ���� sum1���� ����
					int sum2 = count1[i+26] + count2[i+26];	//[i+26]�϶� count1�� count2�� ���� sum2�� ����
					System.out.print(alphabet[i] + ":" + count1[i] + "+" + count2[i] + " = " + sum1 + "��" + "  , ");
					System.out.println(alphabet[i+26] + ":" + count1[i+26] + "+" + count2[i+26] + " = " + sum2 + "��");
				}
			System.out.println("========================");
		}
		
		AnagramNumber r = new AnagramNumber(AnagramNumber.returnx(),AnagramNumber.returny());
		System.out.println("�Ƴ��׷� ���� O�� ����:" + AnagramNumber.returnx());
		System.out.println("�Ƴ��׷� ���� X�� ����:" + AnagramNumber.returny());
		
		scan.close();	//��ĳ�� ��ü ����
	}	
	
}
//anagram���� �Ǻ��ϴ� Ŭ���� ����
class AnagramTest {

	public static void anagram(String a1,String a2) {	//String�� ���� a1,a2
		
			AnagramNumber z = new AnagramNumber(0,0);	//�ؿ��� anagram�� �Ͱ� �ƴ� ���� ������ �����ϴ� Ŭ���� �����ؼ� ���
			
			//�ܾ��� ���� ����
			a1 = a1.replaceAll("\\p{Z}","");
			a2 = a2.replaceAll("\\p{Z}","");
			
			//�� �ܾ��� ���� üũ
			if (a1.length() != a2.length()) {
				System.out.println("���:�� �ܾ��� ���̰� �ٸ��ϴ�.");
				return;
			}
			
			//�ҹ��� ��ȯ�� Char������ �迭 ��ȯ�ϸ鼭 Char�� ���� c1,c2 ����
			char[] c1 = a1.toLowerCase().toCharArray();
			char[] c2 = a2.toLowerCase().toCharArray();
			
			//Arrays.sort() ���� ���� ����
			Arrays.sort(c1);
			Arrays.sort(c2);
			
			//String������ ��ȯ�ϸ鼭 ���� sc1,sc2 ����
			String sc1 = new String(c1);
			String sc2 = new String(c2);
			
			//�ܾ� ���� ��
			if(sc1.equals(sc2)) {
				System.out.println("���:�Ƴ��׷� ���� O");
				z.methodx();	//�ؿ��� ������ anagram���� �����ϴ� �޼ҵ� ���
			} else {
				System.out.println("���:�Ƴ��׷� ���� X");
				z.methody();	//�ؿ��� ������ anagram���� �����ϴ� �޼ҵ� ���
			}
	}
	
}
//anagram�� ���� �����ϴ� Ŭ���� ����
class AnagramNumber {
	
	public static int x;	//anagram�� ��
	public static int y;	//anagram�� �ƴ� ���� ��
	//������-AnagramTest���� ȣ���ؼ� ���
	public AnagramNumber(int x,int y) {
		AnagramNumber.x = x;
		AnagramNumber.y = y;
	}	//anagram�� ���� �����ϰ� 1�� ������Ű�� �޼ҵ�
	public void methodx() {
		x++;
	}	//anagram�� �ƴ� ���� ���� �����ϰ� 1�� ������Ű�� �޼ҵ�
	public void methody() {
		y++;
	}	//������ anagram�� ���� �����ϴ� �޼ҵ�
	public static int returnx() {
		return x;
	}	//������ anagram�� �ƴ� ���� ���� �����ϴ� �޼ҵ�
	public static int returny() {
		return y;
	}
}