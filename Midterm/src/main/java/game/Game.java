package game;
import java.util.*;
class Unit
{
	protected String name; //이름
	protected int hp; //체력
	protected int atk; //공격력
	protected int def; //방어력
	protected int sek; //시야
	protected int man; //소환에 필요한 인구수
	protected int Aman; //소환된 유닛수
	Unit()// 기본적인 유닛 설정
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
	void print() // 유닛의 이름과 개수를 출력합니다.
	{
		if(Aman>0)
		{
			System.out.printf("유닛이름 > %s\n", name);
			System.out.printf(" 유닛의 수 > %d 개\n", Aman);
		}
	}
	void dprint() // 디테일한 유닛의 정보를 출력합니다. 
	{
		System.out.printf("유닛 이름 > %s\n", name);	
		System.out.printf("   체력 > %d\n", hp);
		System.out.printf("   공격력 > %d\n", atk);
		System.out.printf("   방어력 > %d\n",def);
		System.out.printf("   시야 > %d\n", sek);
		System.out.printf("   소환에 필요한 유닛수 > %d\n", man);
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
			System.out.printf("기능을 입력하세요 \n");
			System.out.printf("1번. 유닛 조회 \n");
			System.out.printf("2번. 유닛 생성 \n");
			System.out.printf("3번. 유닛 삭제 \n");
			System.out.printf("10번. 종료 \n");
			System.out.printf("> ");
			sw=scan.nextInt();
			switch(sw)
			{
			case 1:
			{
				System.out.printf("유닛 조회입니다. \n");
				list();
				break;
			}
			case 2:
			{
				System.out.printf("유닛 생성입니다. \n");
				add();
				break;
			}
			case 3:
			{
				System.out.printf("유닛 삭제입니다. \n");
				del();
			}
			}
		}while(sw!=10);
	}
	static void list()// 유닛 목록 및 인구수를 출력합니다.
	{
		Tank.print();
		Battlecruiser.print();
		Ghost.print();
		Marine.print();
		Medic.print();
		System.out.printf("현재 인구수는 > %d/200\n",Player.getnum());
	}
	static void set()// 유닛 수 변경시 총 인구수를 재설정 합니다.
	{
		int man;
		man=Ghost.getAman()*Ghost.getman()+Battlecruiser.getAman()*Battlecruiser.getman()
			+Marine.getAman()*Marine.getman()+Medic.getAman()*Medic.getman()+Tank.getAman()*Tank.getman();
		Player.setnum(man);
	}
	static void add()// 유닛을 추가합니다.
	{
		int n1,n2;
		Scanner scan = new Scanner(System.in);
		System.out.printf("추가할 유닛은 ?\n");
		System.out.printf("1.Tank 2.Battlecruiser 3.Ghost 4.Marine 5.Medic 10.취소 \n > ");
		n1 = scan.nextInt();
		switch(n1)
		{
		case 1:
		{
			Tank.dprint();
			System.out.printf("추가할 유닛개수?(음수입력시 취소)\n >");
			n2 = scan.nextInt();
			if(n2<=0)
				{
				System.out.printf("유닛 생성을 취소합니다.\n");
				break;
				}
			if(Tank.getman()*n2+Player.getnum()>200)
				System.out.printf("최대 유닛 200을 초과합니다. 생성할수 없습니다.\n");
			else 
			{
				Tank.setAman(n2);
				System.out.printf("유닛을 %d마리 총인구수 %d를 소모하여 생성하였습니다.\n", n2, Tank.getman()*n2);
			}
			break;
		}
		case 2:
		{
			Battlecruiser.dprint();
			System.out.printf("추가할 유닛개수?(음수입력시 취소)\n >");
			n2 = scan.nextInt();
			if(n2<=0)
				{
				System.out.printf("유닛 생성을 취소합니다.\n");
				break;
				}
			if(Battlecruiser.getman()*n2+Player.getnum()>200)
				System.out.printf("최대 유닛 200을 초과합니다. 생성할수 없습니다.\n");
			else
			{
				Battlecruiser.setAman(n2);
				System.out.printf("유닛을 %d마리 총인구수 %d를 소모하여 생성하였습니다.\n", n2, Battlecruiser.getman()*n2);
			}
			break;
		}
		case 3:
		{
			Ghost.dprint();
			System.out.printf("추가할 유닛개수?(음수입력시 취소)\n >");
			n2 = scan.nextInt();
			if(n2<=0)
				{
				System.out.printf("유닛 생성을 취소합니다.\n");
				break;
				}
			if(Ghost.getman()*n2+Player.getnum()>200)
				System.out.printf("최대 유닛 200을 초과합니다. 생성할수 없습니다.\n");
			else
			{
				Ghost.setAman(n2);
				System.out.printf("유닛을 %d마리 총인구수 %d를 소모하여 생성하였습니다.\n", n2, Ghost.getman()*n2);
			}
			break;
		}
		case 4:
		{
		Marine.dprint();
		System.out.printf("추가할 유닛개수?(음수입력시 취소)\n >");
			n2 = scan.nextInt();
			if(n2<=0)
				{
				System.out.printf("유닛 생성을 취소합니다.\n");
				break;
				}
			if(Marine.getman()*n2+Player.getnum()>200)
				System.out.printf("최대 유닛 200을 초과합니다. 생성할수 없습니다.\n");
			else
				{
					Marine.setAman(n2);
					System.out.printf("유닛을 %d마리 총인구수 %d를 소모하여 생성하였습니다.\n", n2, Marine.getman()*n2);
				}
				
			break;
		}
		case 5:
		{
			Medic.dprint();
			System.out.printf("추가할 유닛개수?(음수입력시 취소)\n >");
			n2 = scan.nextInt();
			if(n2<=0)
				{
				System.out.printf("유닛 생성을 취소합니다.\n");
				break;
				}
			n2 = scan.nextInt();
			if(Medic.getman()*n2+Player.getnum()>200)
				System.out.printf("최대 유닛 200을 초과합니다. 생성할수 없습니다.\n");
			else
			{
				Medic.setAman(n2);
				System.out.printf("유닛을 %d마리 총인구수 %d를 소모하여 생성하였습니다.\n", n2, Medic.getman()*n2);
			}
			break;
		}
		case 10:
		{
			System.out.printf("유닛 생성을 취소합니다.\n");
		}
		}
		set();
	}
	static void del()// 유닛을 삭제합니다.
	{
		Scanner scan = new Scanner(System.in);
		list();
		System.out.printf("삭제할 유닛은 ?\n");
		System.out.printf("1.Tank 2.Battlecruiser 3.Ghost 4.Marine 5.Medic 10.취소 \n > ");
		int n1, n2;
		n1 = scan.nextInt();
		switch(n1)
		{
		case 1:
		{
			System.out.printf("삭제할 유닛개수?(음수입력시 취소)\n >");
			n2 = scan.nextInt();
			if(n2<=0)
				{
				System.out.printf("유닛 삭제를 취소합니다.\n");
				break;
				}
			if(Tank.getAman()<n2)
			{
				System.out.printf("삭제할 유닛이 원래 유닛보다 많습니다. 삭제할수 없습니다.\n");
				break;
			}
			else
			{
				Tank.setAman(-n2);
				System.out.printf("유닛을 %d마리를 삭제하여 인구수 %d가 늘어났습니다.\n", n2, Tank.getman()*n2);
			}
			break;
		}
		case 2:
		{
			System.out.printf("삭제할 유닛개수?(음수입력시 취소)\n >");
			n2 = scan.nextInt();
			if(n2<=0)
				{
				System.out.printf("유닛 삭제를 취소합니다.\n");
				break;
				}
			if(Battlecruiser.getAman()<n2)
			{
				System.out.printf("삭제할 유닛이 원래 유닛보다 많습니다. 삭제할수 없습니다.\n");
				break;
			}
			else
			{
				Battlecruiser.setAman(-n2);
				System.out.printf("유닛을 %d마리를 삭제하여 인구수 %d가 늘어났습니다.\n", n2, Battlecruiser.getman()*n2);
			}
			break;
		}
		case 3:
		{
			System.out.printf("삭제할 유닛개수?(음수입력시 취소)\n >");
			n2 = scan.nextInt();
			if(n2<=0)
				{
				System.out.printf("유닛 삭제를 취소합니다.\n");
				break;
				}
			if(Ghost.getAman()<n2)
			{
				System.out.printf("삭제할 유닛이 원래 유닛보다 많습니다. 삭제할수 없습니다.\n");
				break;
			}
			else
			{
				Ghost.setAman(-n2);
				System.out.printf("유닛을 %d마리를 삭제하여 인구수 %d가 늘어났습니다.\n", n2, Ghost.getman()*n2);
			}
			break;
		}
		case 4:
		{
			System.out.printf("삭제할 유닛개수?(음수입력시 취소)\n >");
			n2 = scan.nextInt();
			if(n2<=0)
				{
				System.out.printf("유닛 삭제를 취소합니다.\n");
				break;
				}
			if(Marine.getAman()<n2)
			{
				System.out.printf("삭제할 유닛이 원래 유닛보다 많습니다. 삭제할수 없습니다.\n");
				break;
			}
			else
			{
				Marine.setAman(-n2);
				System.out.printf("유닛을 %d마리를 삭제하여 인구수 %d가 늘어났습니다.\n", n2, Marine.getman()*n2);
			}
			break;
		}
		case 5:
		{
			System.out.printf("삭제할 유닛개수?(음수입력시 취소)\n >");
			n2 = scan.nextInt();
			if(n2<=0)
				{
				System.out.printf("유닛 삭제를 취소합니다.\n");
				break;
				}
			if(Medic.getAman()<n2)
			{
				System.out.printf("삭제할 유닛이 원래 유닛보다 많습니다. 삭제할수 없습니다.\n");
				break;
			}
			else
			{
				Medic.setAman(-n2);
				System.out.printf("유닛을 %d마리를 삭제하여 인구수 %d가 늘어났습니다.\n", n2, Medic.getman()*n2);
			}
			break;
		}
		case 10:
		{
			System.out.printf("유닛 생성을 취소합니다.\n");
		}
		}
		set();
	}
}
