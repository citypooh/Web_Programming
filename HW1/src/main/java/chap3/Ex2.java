package chap3;	//�����Կ� Ű�� �о BMI�� �񸸵��� �����ϴ� ���α׷�
	
import java.util.Scanner;	//��ĳ�� �޼ҵ带 ����ϱ� ���� �߰�
	
public class Ex2 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);	//��ĳ�� ��ü ����
		
		double weight,height;	//������,Ű
		double BMI;	//BMI ������
		
		System.out.println("BMI�� �񸸵��� �����ϴ� ���α׷��Դϴ�. ");
		
		System.out.println("������(kg)�� Ű(m)�� �Է��Ͻÿ� : ");
		weight = scan.nextDouble();	//������ �Է�
		height = scan.nextDouble();	//Ű �Է�
		BMI = weight/(height*height);	//BMI�� �����ϴ� ��
		
		if(BMI < 15.0) {	//BMI �������� 15.0 �̸��϶�
			System.out.println("==========================");
			System.out.println("������ ��ü��");
		}
		if(BMI >= 15.0 && BMI < 18.5) {	//BMI �������� 15.0 �̻� 18.5 �̸��϶�
			System.out.println("==========================");
			System.out.println("��ü��");
		}
		if(BMI >= 18.5 && BMI < 23.0) {	//BMI �������� 18.5 �̻� 23.0 �̸��϶�
			System.out.println("==========================");
			System.out.println("����");
		}
		if(BMI >= 23.0 && BMI <= 27.5) {	//BMI �������� 23.0 �̻� 27.5 �����϶�
			System.out.println("==========================");
			System.out.println("��ü��");
		}
		if(BMI > 27.5 && BMI <= 40.0) {	//BMI �������� 27.5 �ʰ� 40.0 �����϶�			
			System.out.println("==========================");
			System.out.println("��");
		}
		if(BMI > 40.0) {	//BMI �������� 40.0 �ʰ��϶�
			System.out.println("==========================");
			System.out.println("������ ��");
		}
		
		scan.close();	//��ĳ�� ��ü ����
	}

}