package chap4;	// �ٺ��δϾ� �˰����� �̿��� �������� ���ϴ� ���α׷�

import java.util.Scanner;	//��ĳ�� �޼ҵ带 ����ϱ� ���� �߰�

public class Ex1 {
	
	public static double babylonianSqrt(double x) {	//�ٺ��δϾ� �޼ҵ� ����
		double guess = x;	//���ϴ� ���� ���� ������ ����
		while(true) {	//while������ �������� ���Ҷ����� �Ʒ� ������ �ݺ�
			double avg = ((x/guess)+guess)/2;	//���ϴ� ���� ���������� ���� ���� ���������� ���
			if(guess == avg) {	//�������� ������ ���� ����� ���� ���
				return guess;	//�������� �������� ����
			}
			guess = avg;	//������ ���� ��� ���� �������� ������ ���ο� ������ ����
		}
	}
	
	public static void main(String[] args) { 
		Scanner scan = new Scanner(System.in); //��ĳ�� ��ü ����
		System.out.print("���ϴ� �� �Է�:");
		double d = scan.nextDouble();	//���ϴ� ���� �Է�
		System.out.println("==========================");
		System.out.print(d + "�� ������:");	
		System.out.printf("%.8f",babylonianSqrt(d));	//�Ҽ��� ���� 8�ڸ� ���� ���ϴ� �ڵ�
	
		scan.close();	//��ĳ�� ��ü ����
		  
	} 
}
