package chap3;	//�� �Ǽ��� �о 2���������� ���� ���ϴ� ���α׷�
	
import java.util.Scanner;	//��ĳ�� �޼ҵ带 ����ϱ� ���� �߰�
	 
public class Ex1 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);	//��ĳ�� ��ü ����
		
		double a,b,c;	//2������ ���:a,1������ ���:b,������� ���:c 
		double d;	//d = (b*b)-(4*a*c)
		double root;	//d�� ������
		double x1,x2;	//2���������� ��
		
		System.out.println("2���������� ���� ���ϴ� ���α׷��Դϴ�. ");
		
		System.out.println("2������ ���(a)�� �Է��Ͻÿ� : ");
		a = scan.nextDouble();	//a�� ���� �Է�
		System.out.println("1������ ���(b)�� �Է��Ͻÿ� : ");
		b = scan.nextDouble();	//b�� ���� �Է�
		System.out.println("������� ���(c)�� �Է��Ͻÿ� : ");
		c = scan.nextDouble();	//c�� ���� �Է�
		
		d = (b*b)-(4*a*c);	//d�� ���� ���� �ּ�ó�� ����
		root = Math.sqrt(d);	//�������� ���ϴ� �޼ҵ� ȣ��
		
		if(d > 0) {	//2���� �Ǳ��� ���� ���
			x1 = ((-b-root)/(2*a));
			x2 = ((-b+root)/(2*a));
			System.out.println("==========================");
			System.out.println("2���������� ���� " + x1 + " �� " + x2 + " �Դϴ�. ");
		}
		if(d == 0) {	//�߱��� ���� ���
			x1 = x2 = (-b+root)/(2*a);
			System.out.println("==========================");
			System.out.println("2���������� ���� " + x1 + " �Դϴ�. ");
		}
		if(d < 0) {	//�Ǳ��� ���� ���
			System.out.println("==========================");
			System.out.println("�Ǳ��� ����");
		}
		
		scan.close();	//��ĳ�� ��ü ����
	}
	
}