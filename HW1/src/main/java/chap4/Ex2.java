package chap4;	// ���� �ŵ����� �Լ��� ����� ���α׷�
	
import java.util.Scanner;	//��ĳ�� �޼ҵ带 ����ϱ� ���� �߰�

public class Ex2 {
	
	public static int fastPower(int x,int n) {	//���� �ŵ����� �޼ҵ� ����
		if (n == 0) {	//x�� 0���� ���
	        return 1;
	    }
	    int y = fastPower(x, n / 2);	//x�� n/2���� ���� �ŵ����� �޼ҵ带 ���� ������Ų �ڵ�
	    int z = y * y;	//x�� n/2���� �ŵ������� �ڵ�
	 
	    if (n % 2 == 0) {	//n�� ¦���� ���
	        return z;
	    } else {	//n�� ¦���� �ƴ� ���
	        return x * z;
	    }
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);	//��ĳ�� ��ü ����
		System.out.println("�ŵ����� �� ���� �Է�:");
		int x = scan.nextInt();	//x�� �� �Է�
		System.out.println("�ŵ����� �� Ƚ�� �Է�:");
		int n = scan.nextInt();	//n�� �� �Է�
		System.out.println("==========================");
		System.out.println(x + "�� " + n + "���� = " + fastPower(x,n));	//���� �ŵ����� �޼ҵ带 ���� ���� x�� n���� ���
		
		scan.close();	//��ĳ�� ��ü ����
	}

}
