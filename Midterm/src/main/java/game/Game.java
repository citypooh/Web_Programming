package game;
import java.util.*;
class Unit
{
	protected String name; //�̸�
	protected int hp; //ü��
	protected int atk; //���ݷ�
	protected int def; //����
	protected int sek; //�þ�
	protected int man; //��ȯ�� �ʿ��� �α���
	protected int Aman; //��ȯ�� ���ּ�
	Unit()// �⺻���� ���� ����
	{
		hp=100; 
		atk=10;
		def=10;
		sek=3;
		man=1;
		Aman=0;
	}
	int getman()
	{
		return man;
	}
	int getAman()
	{
		return Aman;
	}
	void setAman(int n)
	{
		Aman+=n;
	}
	void print() // ������ �̸��� ������ ����մϴ�.
	{
		if(Aman>0)
		{
			System.out.printf("�����̸� > %s\n", name);
			System.out.printf(" ������ �� > %d ��\n", Aman);
		}
	}
	void dprint() // �������� ������ ������ ����մϴ�. 
	{
		System.out.printf("���� �̸� > %s\n", name);	
		System.out.printf("   ü�� > %d\n", hp);
		System.out.printf("   ���ݷ� > %d\n", atk);
		System.out.printf("   ���� > %d\n",def);
		System.out.printf("   �þ� > %d\n", sek);
		System.out.printf("   ��ȯ�� �ʿ��� ���ּ� > %d\n", man);
		}
}
public class Game 
{
	static ghost Ghost = new ghost();
	static Battlecruiser Battlecruiser = new Battlecruiser();
	static Marine Marine = new Marine();
	static medic Medic = new medic();
	static tank Tank = new tank();
	static Player Player = new Player();
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		int sw;
		
		do 
		{
			System.out.printf("����� �Է��ϼ��� \n");
			System.out.printf("1��. ���� ��ȸ \n");
			System.out.printf("2��. ���� ���� \n");
			System.out.printf("3��. ���� ���� \n");
			System.out.printf("10��. ���� \n");
			System.out.printf("> ");
			sw=scan.nextInt();
			switch(sw)
			{
			case 1:
			{
				System.out.printf("���� ��ȸ�Դϴ�. \n");
				list();
				break;
			}
			case 2:
			{
				System.out.printf("���� �����Դϴ�. \n");
				add();
				break;
			}
			case 3:
			{
				System.out.printf("���� �����Դϴ�. \n");
				del();
			}
			}
		}while(sw!=10);
	}
	static void list()// ���� ��� �� �α����� ����մϴ�.
	{
		Tank.print();
		Battlecruiser.print();
		Ghost.print();
		Marine.print();
		Medic.print();
		System.out.printf("���� �α����� > %d/200\n",Player.getnum());
	}
	static void set()// ���� �� ����� �� �α����� �缳�� �մϴ�.
	{
		int man;
		man=Ghost.getAman()*Ghost.getman()+Battlecruiser.getAman()*Battlecruiser.getman()
			+Marine.getAman()*Marine.getman()+Medic.getAman()*Medic.getman()+Tank.getAman()*Tank.getman();
		Player.setnum(man);
	}
	static void add()// ������ �߰��մϴ�.
	{
		int n1,n2;
		Scanner scan = new Scanner(System.in);
		System.out.printf("�߰��� ������ ?\n");
		System.out.printf("1.Tank 2.Battlecruiser 3.Ghost 4.Marine 5.Medic 10.��� \n > ");
		n1 = scan.nextInt();
		switch(n1)
		{
		case 1:
		{
			Tank.dprint();
			System.out.printf("�߰��� ���ְ���?(�����Է½� ���)\n >");
			n2 = scan.nextInt();
			if(n2<=0)
				{
				System.out.printf("���� ������ ����մϴ�.\n");
				break;
				}
			if(Tank.getman()*n2+Player.getnum()>200)
				System.out.printf("�ִ� ���� 200�� �ʰ��մϴ�. �����Ҽ� �����ϴ�.\n");
			else 
			{
				Tank.setAman(n2);
				System.out.printf("������ %d���� ���α��� %d�� �Ҹ��Ͽ� �����Ͽ����ϴ�.\n", n2, Tank.getman()*n2);
			}
			break;
		}
		case 2:
		{
			Battlecruiser.dprint();
			System.out.printf("�߰��� ���ְ���?(�����Է½� ���)\n >");
			n2 = scan.nextInt();
			if(n2<=0)
				{
				System.out.printf("���� ������ ����մϴ�.\n");
				break;
				}
			if(Battlecruiser.getman()*n2+Player.getnum()>200)
				System.out.printf("�ִ� ���� 200�� �ʰ��մϴ�. �����Ҽ� �����ϴ�.\n");
			else
			{
				Battlecruiser.setAman(n2);
				System.out.printf("������ %d���� ���α��� %d�� �Ҹ��Ͽ� �����Ͽ����ϴ�.\n", n2, Battlecruiser.getman()*n2);
			}
			break;
		}
		case 3:
		{
			Ghost.dprint();
			System.out.printf("�߰��� ���ְ���?(�����Է½� ���)\n >");
			n2 = scan.nextInt();
			if(n2<=0)
				{
				System.out.printf("���� ������ ����մϴ�.\n");
				break;
				}
			if(Ghost.getman()*n2+Player.getnum()>200)
				System.out.printf("�ִ� ���� 200�� �ʰ��մϴ�. �����Ҽ� �����ϴ�.\n");
			else
			{
				Ghost.setAman(n2);
				System.out.printf("������ %d���� ���α��� %d�� �Ҹ��Ͽ� �����Ͽ����ϴ�.\n", n2, Ghost.getman()*n2);
			}
			break;
		}
		case 4:
		{
		Marine.dprint();
		System.out.printf("�߰��� ���ְ���?(�����Է½� ���)\n >");
			n2 = scan.nextInt();
			if(n2<=0)
				{
				System.out.printf("���� ������ ����մϴ�.\n");
				break;
				}
			if(Marine.getman()*n2+Player.getnum()>200)
				System.out.printf("�ִ� ���� 200�� �ʰ��մϴ�. �����Ҽ� �����ϴ�.\n");
			else
				{
					Marine.setAman(n2);
					System.out.printf("������ %d���� ���α��� %d�� �Ҹ��Ͽ� �����Ͽ����ϴ�.\n", n2, Marine.getman()*n2);
				}
				
			break;
		}
		case 5:
		{
			Medic.dprint();
			System.out.printf("�߰��� ���ְ���?(�����Է½� ���)\n >");
			n2 = scan.nextInt();
			if(n2<=0)
				{
				System.out.printf("���� ������ ����մϴ�.\n");
				break;
				}
			n2 = scan.nextInt();
			if(Medic.getman()*n2+Player.getnum()>200)
				System.out.printf("�ִ� ���� 200�� �ʰ��մϴ�. �����Ҽ� �����ϴ�.\n");
			else
			{
				Medic.setAman(n2);
				System.out.printf("������ %d���� ���α��� %d�� �Ҹ��Ͽ� �����Ͽ����ϴ�.\n", n2, Medic.getman()*n2);
			}
			break;
		}
		case 10:
		{
			System.out.printf("���� ������ ����մϴ�.\n");
		}
		}
		set();
	}
	static void del()// ������ �����մϴ�.
	{
		Scanner scan = new Scanner(System.in);
		list();
		System.out.printf("������ ������ ?\n");
		System.out.printf("1.Tank 2.Battlecruiser 3.Ghost 4.Marine 5.Medic 10.��� \n > ");
		int n1, n2;
		n1 = scan.nextInt();
		switch(n1)
		{
		case 1:
		{
			System.out.printf("������ ���ְ���?(�����Է½� ���)\n >");
			n2 = scan.nextInt();
			if(n2<=0)
				{
				System.out.printf("���� ������ ����մϴ�.\n");
				break;
				}
			if(Tank.getAman()<n2)
			{
				System.out.printf("������ ������ ���� ���ֺ��� �����ϴ�. �����Ҽ� �����ϴ�.\n");
				break;
			}
			else
			{
				Tank.setAman(-n2);
				System.out.printf("������ %d������ �����Ͽ� �α��� %d�� �þ���ϴ�.\n", n2, Tank.getman()*n2);
			}
			break;
		}
		case 2:
		{
			System.out.printf("������ ���ְ���?(�����Է½� ���)\n >");
			n2 = scan.nextInt();
			if(n2<=0)
				{
				System.out.printf("���� ������ ����մϴ�.\n");
				break;
				}
			if(Battlecruiser.getAman()<n2)
			{
				System.out.printf("������ ������ ���� ���ֺ��� �����ϴ�. �����Ҽ� �����ϴ�.\n");
				break;
			}
			else
			{
				Battlecruiser.setAman(-n2);
				System.out.printf("������ %d������ �����Ͽ� �α��� %d�� �þ���ϴ�.\n", n2, Battlecruiser.getman()*n2);
			}
			break;
		}
		case 3:
		{
			System.out.printf("������ ���ְ���?(�����Է½� ���)\n >");
			n2 = scan.nextInt();
			if(n2<=0)
				{
				System.out.printf("���� ������ ����մϴ�.\n");
				break;
				}
			if(Ghost.getAman()<n2)
			{
				System.out.printf("������ ������ ���� ���ֺ��� �����ϴ�. �����Ҽ� �����ϴ�.\n");
				break;
			}
			else
			{
				Ghost.setAman(-n2);
				System.out.printf("������ %d������ �����Ͽ� �α��� %d�� �þ���ϴ�.\n", n2, Ghost.getman()*n2);
			}
			break;
		}
		case 4:
		{
			System.out.printf("������ ���ְ���?(�����Է½� ���)\n >");
			n2 = scan.nextInt();
			if(n2<=0)
				{
				System.out.printf("���� ������ ����մϴ�.\n");
				break;
				}
			if(Marine.getAman()<n2)
			{
				System.out.printf("������ ������ ���� ���ֺ��� �����ϴ�. �����Ҽ� �����ϴ�.\n");
				break;
			}
			else
			{
				Marine.setAman(-n2);
				System.out.printf("������ %d������ �����Ͽ� �α��� %d�� �þ���ϴ�.\n", n2, Marine.getman()*n2);
			}
			break;
		}
		case 5:
		{
			System.out.printf("������ ���ְ���?(�����Է½� ���)\n >");
			n2 = scan.nextInt();
			if(n2<=0)
				{
				System.out.printf("���� ������ ����մϴ�.\n");
				break;
				}
			if(Medic.getAman()<n2)
			{
				System.out.printf("������ ������ ���� ���ֺ��� �����ϴ�. �����Ҽ� �����ϴ�.\n");
				break;
			}
			else
			{
				Medic.setAman(-n2);
				System.out.printf("������ %d������ �����Ͽ� �α��� %d�� �þ���ϴ�.\n", n2, Medic.getman()*n2);
			}
			break;
		}
		case 10:
		{
			System.out.printf("���� ������ ����մϴ�.\n");
		}
		}
		set();
	}
}
